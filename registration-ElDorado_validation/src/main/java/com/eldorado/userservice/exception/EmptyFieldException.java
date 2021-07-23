package com.eldorado.userservice.exception;

public class EmptyFieldException extends Exception {
    public EmptyFieldException() {
        super("Field cannot be empty");
    }

    public EmptyFieldException(String message) {
        super(message);
    }
}
