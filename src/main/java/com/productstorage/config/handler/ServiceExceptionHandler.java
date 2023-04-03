package com.productstorage.config.handler;

import com.productstorage.util.error.ApiErrorMessage;
import com.productstorage.util.error.ErrorMessage;
import com.productstorage.util.error.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> serviceException(ServiceException exception){
        ApiErrorMessage message = new ApiErrorMessage();
        message.setMessage(exception.getMessage());
        return new ResponseEntity<>(message,exception.getStatus());
    }
    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<?> validException(Exception exception){
        ApiErrorMessage message = new ApiErrorMessage();
        message.setMessage(ErrorMessage.VALID.getCode());
        return new ResponseEntity<>(message, ErrorMessage.VALID.getStatus());
    }
}
