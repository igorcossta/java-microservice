package com.igorcossta.author;

import com.igorcossta.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<?> handleApiException(ApiException exception, WebRequest req) {
        log.info("an exception occur with message {} on uri {}", exception.getMessage(), req.getContextPath());

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
