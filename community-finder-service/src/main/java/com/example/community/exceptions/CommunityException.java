package com.example.community.exceptions;

public class CommunityException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public CommunityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunityException(String message, String errorCode) {
        super(message);
    }
}
