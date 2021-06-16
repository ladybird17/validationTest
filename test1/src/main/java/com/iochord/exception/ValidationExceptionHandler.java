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
        log.info("############"+exception.getBindingResult().getAllErrors());
        log.info("@@@@@@@@"+exception.getAllErrors());
        log.info("----------------"+exception.getTarget()); //입력했던 전체값

        List<Object> errorList = new ArrayList<>();

        for(int i =0; i<exception.getErrorCount(); i++){
            log.info(i+"번째 메시지 : "+exception.getAllErrors().get(i).getDefaultMessage());
            log.info("objectName : "+exception.getAllErrors().get(i).getObjectName());
            log.info("code : "+exception.getAllErrors().get(i).getCode());
            log.info("전문 : "+exception.getAllErrors().get(i));
            log.info("codes : "+exception.getAllErrors().get(i).getCodes());

            errorList.add(exception.getAllErrors().get(i).getDefaultMessage());
        }

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);

    }
}
