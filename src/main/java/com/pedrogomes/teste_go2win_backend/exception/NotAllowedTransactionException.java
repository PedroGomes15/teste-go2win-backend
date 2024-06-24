package com.pedrogomes.teste_go2win_backend.exception;

public class NotAllowedTransactionException extends RuntimeException {
    public NotAllowedTransactionException(String message) {
        super(message);
    }
}
