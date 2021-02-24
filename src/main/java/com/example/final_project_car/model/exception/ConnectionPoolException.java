package com.example.final_project_car.model.exception;

/**
 * Exception, that throws by Pool layer
 */

public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 8820982417068853008L;

    public ConnectionPoolException() { }

    public ConnectionPoolException(String message) {
        super(message);
    }


    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }


    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
