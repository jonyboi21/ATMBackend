package com.atm.atmproject.handler;

import com.atm.atmproject.error.ValidationError;
import com.atm.atmproject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlankHandlerClass extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleErrorFetchingMultipleAccountsResource(ResourceNotFoundException rnfe, HttpServletRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setCode("404");
        validationError.setMessage("error fetching customer accounts");
        return new ResponseEntity<>(validationError, null, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleErrorFetchingAccountResource(ResourceNotFoundException rnfe, HttpServletRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setCode("404");
        validationError.setMessage("error fetching account");
        return new ResponseEntity<>(validationError, null, HttpStatus.NOT_FOUND);
    }

}
