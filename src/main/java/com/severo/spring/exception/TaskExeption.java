package com.severo.spring.exception;

public class TaskExeption extends Exception{
    private ErrorCode errorCode;

    public TaskExeption(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getMessageError(){
        return errorCode+": "+getMessage();
    }
}
