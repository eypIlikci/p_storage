package com.productstorage.util.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceException extends RuntimeException{
    private final HttpStatus status;

    public ServiceException(ErrorMessage errorMessage) {
        super(errorMessage.getCode());
        this.status =errorMessage.getStatus();
    }

    public HttpStatus getStatus() {
        return status;
    }
}
