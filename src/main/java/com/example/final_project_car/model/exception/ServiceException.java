package com.example.final_project_car.model.exception;

/**
 * Exception, that throws by Service layer
 */

public class ServiceException extends Exception {
    private static final long serialVersionUID = 5870236736703427566L;

    public ServiceException() { }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
