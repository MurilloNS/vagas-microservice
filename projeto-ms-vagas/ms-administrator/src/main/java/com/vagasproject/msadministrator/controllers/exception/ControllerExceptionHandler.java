package com.vagasproject.msadministrator.controllers.exception;

import com.vagasproject.msadministrator.services.exceptions.EmailAlreadyExist;
import com.vagasproject.msadministrator.services.exceptions.ErrorInsertVagaException;
import com.vagasproject.msadministrator.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EmailAlreadyExist.class)
    public ResponseEntity<StandardError> emailAlreadyExist(EmailAlreadyExist ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(ErrorInsertVagaException.class)
    public ResponseEntity<StandardError> errorInsertVaga(ErrorInsertVagaException ex, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
