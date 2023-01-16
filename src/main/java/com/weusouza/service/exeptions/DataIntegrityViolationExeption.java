package com.weusouza.service.exeptions;

public class DataIntegrityViolationExeption extends RuntimeException {

    public DataIntegrityViolationExeption(String message) {
        super(message);
    }

    public DataIntegrityViolationExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
