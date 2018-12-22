package com.dece.userprofile.handler;

public class CustomException extends RuntimeException {

    private String customMessage;

    public CustomException(String customMessage) { this.customMessage = customMessage; }

    public String getCustomMessage() { return customMessage; }
}
