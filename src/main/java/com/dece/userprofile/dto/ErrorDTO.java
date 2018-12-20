package com.dece.userprofile.dto;

import java.util.Objects;

public class ErrorDTO {
    private int code;
    private String message;

    public ErrorDTO() { }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDTO errorDTO = (ErrorDTO) o;
        return code == errorDTO.code &&
                Objects.equals(message, errorDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
