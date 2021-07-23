package com.eldorado.userservice.exception;

public class InvalidDataException extends Exception {
	public InvalidDataException() {
        super("Invalid Data Entered!");
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
