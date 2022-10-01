package com.lottyx.lottyxbackend.exception;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String message){
        super(message);
    }
}
