package com.example.final_project_car.model.exception;

/**
 * Exception, that throws by Dao layer
 */

public class DAOException extends Exception {
    private static final long serialVersionUID = -2797613441106399004L;

    public DAOException() { }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }


}
