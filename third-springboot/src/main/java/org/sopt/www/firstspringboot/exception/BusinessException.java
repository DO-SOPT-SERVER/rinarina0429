package org.sopt.www.firstspringboot.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
