package com.my.restapi.exception;

import com.my.restapi.dto.ExceptionResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@Log4j2
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDto> handleException(EntityNotFoundException exception) {
        ExceptionResponseDto errorResponseDto = new ExceptionResponseDto(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now());
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDto> handleException(UserAlreadyExistException exception) {
        ExceptionResponseDto errorResponseDto = new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDto> handleException(TaskAlreadyExistException exception) {
        ExceptionResponseDto errorResponseDto = new ExceptionResponseDto(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.internalServerError().build();
    }
}