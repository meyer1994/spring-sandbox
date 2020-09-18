package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.util.Optional;

@ControllerAdvice
public class DemoAdvice {
    @ExceptionHandler(value = DemoException.class)
    public ResponseEntity<Problem> problemResponseEntity(final DemoException e, final WebRequest webRequest) {
        final String id = e.getId().toString();
        final String message = String.format("Entity %s not found", id);
        final Problem problem = Problem.valueOf(Status.NOT_FOUND, message);
        return ResponseEntity.of(Optional.of(problem));
    }
}
