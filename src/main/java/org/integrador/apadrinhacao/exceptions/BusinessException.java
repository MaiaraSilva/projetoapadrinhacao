package org.integrador.apadrinhacao.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException (String message) {
        super(String.format(message));
    }
}
