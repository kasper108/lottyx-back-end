package com.lottyx.lottyxbackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super("Message");
    };
}
