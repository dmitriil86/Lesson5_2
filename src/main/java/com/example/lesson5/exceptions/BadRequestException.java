package com.example.lesson5.exceptions;

public class BadRequestException extends Exception{

    public BadRequestException(String nameParam)
    {
        super(nameParam);
    }
}
