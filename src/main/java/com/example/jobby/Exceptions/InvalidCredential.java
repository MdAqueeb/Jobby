package com.example.jobby.Exceptions;

public class InvalidCredential extends RuntimeException {
    public InvalidCredential(String msg){
        super(msg);
    }
}
