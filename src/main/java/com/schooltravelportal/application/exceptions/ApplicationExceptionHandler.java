package com.schooltravelportal.application.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto exceptionHandler(HttpServletRequest request, IllegalArgumentException e) {
        final String error = prepareMessage(request, e);
        log.error(error);
        return ErrorDto.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    private String prepareMessage(final HttpServletRequest request, final IllegalArgumentException e) {
        return "Error while consuming" +
                request.getRequestURI() +
                ", exception" +
                e.getMessage() +
                "\n" +
                ExceptionUtils.getStackTrace(e);
    }
}
