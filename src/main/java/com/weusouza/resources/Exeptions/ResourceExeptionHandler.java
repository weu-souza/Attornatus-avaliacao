package com.weusouza.resources.Exeptions;

import com.weusouza.service.exeptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExeptionHandler {

    @ExceptionHandler(ObjectNotFoundExeption.class)

    public ResponseEntity<StandardError> objectNotFoundExeption(ObjectNotFoundExeption e, ServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationExeption.class)

    public ResponseEntity<StandardError> dataIntegrityViolationExeption(DataIntegrityViolationExeption e, ServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<StandardError> ValidationError(MethodArgumentNotValidException e, ServletRequest request) {
        ValidatiionError error = new ValidatiionError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "erro na validação dos campos");
        for (FieldError x : e.getBindingResult().getFieldErrors()){
            error.addErros(x.getField(),x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
