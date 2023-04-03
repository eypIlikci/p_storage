package com.productstorage.util.error;

import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;
public enum ErrorMessage {
    VALID(BAD_REQUEST,"000"),
    ID(BAD_REQUEST,"001"),
    USED_NAME(BAD_REQUEST,"002")
    ;
    private final HttpStatus status;
    private final String code;

    ErrorMessage(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
