package com.example.final_project_car.model.pool;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private final static ConnectionPool instance = new ConnectionPool();
    private static BlockingQueue<Connection> connectionQueue;
    private static BlockingQueue<Connection> givenQueue;

    private final static String DB_PROPERTY = "db";

    private final String driver;
    private final String url;
    private final String user;
    private final String password;
    private int poolSize;

    public static ConnectionPool getInstance() {
        return instance;
    }

    private ConnectionPool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_PROPERTY);
        driver = resourceBundle.getString(Parameters.DB_DRIVER);
        url = resourceBundle.getString(Parameters.DB_URL);
        user = resourceBundle.getString(Parameters.DB_USER);
        password = resourceBundle.getString(Parameters.DB_PASSWORD);

        try {
            poolSize = Integer.parseInt(resourceBundle.getString(Parameters.POOL_SIZE));
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid parameter value db.poolsize");
            poolSize = Parameters.DEFAULT_POOL_SIZE;
        }

        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        givenQueue = new ArrayBlockingQueue<>(poolSize);

        try {
            initPool();
        } catch (ConnectionPoolException e) {
            LOGGER.error("Couldn't initialize pool in constructor");
        }
    }

    private void initPool() throws ConnectionPoolException  {
        try {
            Class.forName(driver);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                ConnectionImpl connectionImpl = new ConnectionImpl(connection);
                connectionQueue.add(connectionImpl);
            }
        } catch (SQLException e) {
            LOGGER.error("Couldn't initialize pool", e);
            throw new ConnectionPoolException(e);
        }
        catch (ClassNotFoundException e) {
            LOGGER.error("Couldn't find database driver class");
            throw new ConnectionPoolException(e);
        }
    }

    public Connection getConnection() throws ConnectionPoolException {
        Connection connection;
        try {
            connection = connectionQueue.take();
            givenQueue.add(connection);
        } catch (InterruptedException e) {
            LOGGER.error("Error in getting connection", e);
            throw new ConnectionPoolException(e);
        }

        return connection;
    }

    public void closeConnection(Connection connection, Statement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Attempting to close closed connection", e);
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            LOGGER.error("An error occurred while trying to close a statement");
        }
    }

    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
           LOGGER.error("Attempting to close closed connection");
        }

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            LOGGER.error("An error occurred while trying to close a Statement");
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.error("An error occurred while trying to close a Result Set");
        }
    }

    public void dropConnections() {
        for (int i = 0; i < poolSize; i++) {
            try {
                ((ConnectionImpl) connectionQueue.take()).trueClose();
            } catch (SQLException e) {
                LOGGER.error("Couldn't close a connection");
            } catch (InterruptedException e) {
                LOGGER.error("Couldn't get a connection");
            }
        }
    }

    public void rebootConnectionPool() throws ConnectionPoolException {
        dropConnections();
        initPool();
    }



    private static class ConnectionImpl implements Connection {
        private Connection connection;

        public ConnectionImpl(Connection connection) throws SQLException {
            this.connection = connection;
            this.connection.setAutoCommit(true);
        }

        private void trueClose() throws SQLException {
            connection.close();
        }
        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return connection.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return connection.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return connection.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            connection.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return connection.getAutoCommit();
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public void close() throws SQLException {
            if (connection.isClosed()) {
                throw new SQLException("Trying to close closed connection");
            }
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            if (!givenQueue.remove(this)) {
                throw new SQLException("Error deleting connection from the given connections pool");
            }
            if (!connectionQueue.offer(this)) {
                throw new SQLException("Error allocating connection in the pool");
            }
        }

        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return connection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            connection.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return connection.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            connection.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            connection.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return connection.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            connection.clearWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            connection.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            connection.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return connection.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return null;
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            connection.rollback(savepoint);
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            connection.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(sql, autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return connection.prepareStatement(sql, columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return connection.prepareStatement(sql, columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return connection.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            connection.setClientInfo(name, value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            connection.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return connection.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return connection.createArrayOf(typeName, elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return connection.createStruct(typeName, attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            connection.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            connection.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            connection.setNetworkTimeout(executor, milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return connection.getNetworkTimeout();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return connection.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return connection.isWrapperFor(iface);
        }
    }
}
