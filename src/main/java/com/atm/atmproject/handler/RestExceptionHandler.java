package com.atm.atmproject.handler;
import com.atm.atmproject.error.ValidationError;
import com.atm.atmproject.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        ValidationError validationError = new ValidationError();
        validationError.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        validationError.setMessage("Error fetching account");
        return new ResponseEntity<>(validationError, HttpStatus.NOT_FOUND);
    }








}
