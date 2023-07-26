package tech.leonam.microservico.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
/*
* Você pode remover essa classe caso vá usar só com proxy reverso.
* */
@RestControllerAdvice
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var errorMessageBuilder = new StringBuilder();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessageBuilder.append(error.getDefaultMessage()).append(" ");
        }
        return ResponseEntity.badRequest().body(errorMessageBuilder.toString());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest(IllegalArgumentException ex, HttpServletRequest request) {
        System.out.println("Ip do meliante: " + request.getRemoteAddr());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle404(NoHandlerFoundException ex, HttpServletRequest request) {
        System.out.println("Ip do meliante" + request.getRemoteAddr() + ex.getMessage());
    }
}
