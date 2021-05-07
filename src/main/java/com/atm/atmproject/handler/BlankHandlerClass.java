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
        validationError.setMessage("error fetching accounts");
        return new ResponseEntity<>(validationError, null, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleErrorFetchingAccountResource(ResourceNotFoundException rnfe, HttpServletRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setCode("404");
        validationError.setMessage("error fetching account");
        return new ResponseEntity<>(validationError, null, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manve, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationError validationError = new ValidationError();
        // Populate validationError instance
        validationError.setTimeStamp(new Date().getTime());
        validationError.setStatus(HttpStatus.BAD_REQUEST.value());
        validationError.setTitle("Validation Failed");
        validationError.setDetail("Input validation failed");
        validationError.setDeveloperMessage(manve.getClass().getName());
        // Create ValidationError instances
        List<FieldError> fieldErrors =  manve.getBindingResult().getFieldErrors();
        for(FieldError fe : fieldErrors) {
            List<ValidationError> validationErrorList = validationError.getErrors().get(fe.getField());
            if(validationErrorList == null) {
                validationErrorList = new ArrayList<ValidationError>();
                validationError.getErrors().put(fe.getField(), validationErrorList);
            }
            ValidationError validationError = new ValidationError();
            validationError.setCode(fe.getCode());
            validationError.setMessage(messageSource.getMessage(fe, null));
            validationErrorList.add(validationError);
        }
        return handleExceptionInternal(manve, validationError, headers, status, request);
    }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(status.value());
        errorDetail.setTitle("Message Not Readable");
        errorDetail.setDetail(ex.getMessage());
        errorDetail.setDeveloperMessage(ex.getClass().getName());
        return handleExceptionInternal(ex, errorDetail, headers, status, request);
    }

}
