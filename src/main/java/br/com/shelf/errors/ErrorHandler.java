package br.com.shelf.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorObject>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

        List<ErrorObject> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError ->
                new ErrorObject(fieldError.getDefaultMessage(), fieldError.getRejectedValue(), fieldError.getField()))
                .collect(Collectors.toList());


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
