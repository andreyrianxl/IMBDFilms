package com.IMBDFilms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler(FilmeNaoencontradoException.class)
    public ResponseEntity<ResponseError> filmNotFound(FilmeNaoencontradoException exception) {
        ResponseError error = new ResponseError(exception.getMessage(), HttpStatus.NOT_FOUND.value(),
                LocalDate.now());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> validationError(MethodArgumentNotValidException exception) {

        List<String> listaDeErros = new ArrayList<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            listaDeErros.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        ResponseError error = new ResponseError("Falha na validação. Verifique os campos abaixo.", HttpStatus.BAD_REQUEST.value(),
                LocalDate.now(), listaDeErros);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
