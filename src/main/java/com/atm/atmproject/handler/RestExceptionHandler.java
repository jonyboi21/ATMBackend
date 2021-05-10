package com.atm.atmproject.handler;
import com.atm.atmproject.error.ValidationError;
import com.atm.atmproject.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        ValidationError validationError = new ValidationError();
        validationError.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        validationError.setMessage(rnfe.getMessage());
        return new ResponseEntity<>(validationError, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid (MethodArgumentNotValidException manve, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setCode(String.valueOf(status));
        validationError.setMessage("Error");
        return handleExceptionInternal(manve, validationError, headers, status, request);
    }

}
