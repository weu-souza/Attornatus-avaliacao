package com.weusouza.service.exeptions;

public class ObjectNotFoundExeption extends RuntimeException{
    public ObjectNotFoundExeption(String message){
        super(message);
    }
    public ObjectNotFoundExeption(String message, Throwable cause){
        super(message,cause);
    }
}
