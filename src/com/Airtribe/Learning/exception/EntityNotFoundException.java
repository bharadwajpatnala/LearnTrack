package com.Airtribe.Learning.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message)
    {
        super(message);
    }
}
