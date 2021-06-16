package com.iochord.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {
    //handling custom validation error

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception){

        log.info("-------------"+exception.getFieldValue("userName"));

        List<Object> errorList = new ArrayList<>();

        for(int i =0; i<exception.getErrorCount(); i++){
            errorList.add(exception.getAllErrors().get(i).getDefaultMessage());
        }

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);

    }
}
