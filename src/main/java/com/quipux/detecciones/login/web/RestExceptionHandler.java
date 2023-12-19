package com.quipux.detecciones.login.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quipux.detecciones.login.domain.PostNotFoundException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

// see: https://stackoverflow.com/questions/47631243/spring-5-reactive-webexceptionhandler-is-not-getting-called
// and https://docs.spring.io/spring-boot/docs/2.0.0.M7/reference/html/boot-features-developing-web-applications.html#boot-features-webflux-error-handling
// and https://stackoverflow.com/questions/48047645/how-to-write-messages-to-http-body-in-spring-webflux-webexceptionhandlder/48057896#48057896
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ProblemDetail handlePostNotFoundException(PostNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Post Not Found");
        problemDetail.setType(URI.create("http://example.com/api/errors/not_found"));
        return problemDetail;
    }

}
