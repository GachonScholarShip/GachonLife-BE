package com.gachonproject.buildingservice.global.common.exception;

import com.gachonproject.buildingservice.global.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_FORMAT      = "Class: {}, Status: {}, Message: {}";
    private static final String VALID_EXCEPTION = "Validation failed";

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Void>> handleBase(BaseException e) {
        log.warn(LOG_FORMAT, e.getClass().getSimpleName(), e.getStatus(), e.getMessage());
        return ResponseEntity
                .status(e.getStatus())
                .body(ApiResponse.response(e.getStatus(), e.getMessage()));
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, BindException.class })
    public ResponseEntity<ApiResponse<List<ErrorResponse>>> handleValidation(Exception e) {
        List<ErrorResponse> errors = ((BindException) e).getBindingResult()
                .getFieldErrors().stream()
                .map(fe -> ErrorResponse.builder()
                        .errorField(fe.getField())
                        .errorMessage(fe.getDefaultMessage())
                        .inputValue(fe.getRejectedValue())
                        .build())
                .toList();

        log.warn(LOG_FORMAT, e.getClass().getSimpleName(), BAD_REQUEST, VALID_EXCEPTION);
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ApiResponse.response(BAD_REQUEST, VALID_EXCEPTION, errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleOther(Exception e) {
        log.error(LOG_FORMAT, e.getClass().getSimpleName(), INTERNAL_SERVER_ERROR, e.getMessage());
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ApiResponse.response(INTERNAL_SERVER_ERROR, e.getMessage()));
    }
}
