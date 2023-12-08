package org.sopt.www.firstspringboot.exception.model;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
