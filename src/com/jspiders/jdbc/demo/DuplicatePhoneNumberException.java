package com.jspiders.jdbc.demo;

public class DuplicatePhoneNumberException extends RuntimeException{
    public DuplicatePhoneNumberException(String message)
    {
        super(message);
    }
}
