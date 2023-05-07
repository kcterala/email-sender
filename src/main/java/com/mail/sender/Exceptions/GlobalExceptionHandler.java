package com.mail.sender.Exceptions;


import com.mail.sender.Pojos.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidContentException.class)
    public ResponseEntity<ErrorObject> handleException(InvalidContentException e, HttpServletRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.statusCode = 3;
        errorObject.message = e.getMessage();

        return new ResponseEntity<>(errorObject, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(PartnerAPIException.class)
    public ResponseEntity<ErrorObject> handleException(PartnerAPIException e, HttpServletRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.statusCode = 3;
        errorObject.message = e.getMessage();

        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
