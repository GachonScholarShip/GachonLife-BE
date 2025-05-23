package com.gachonproject.userservice.global.common.exception;

import com.gachonproject.userservice.global.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Hidden;
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
@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {

    // response format
    private static final String LOG_FORMAT = "Class: {}, Code : {}, Message : {}";
    private static final String VALID_EXCEPTION = "Validation failed";

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Void>> handleException(BaseException e) {
        return exceptionResponse(e, e.getStatus(), e.getMessage(), null);
    }

    // BindException 처리
    @ExceptionHandler({BindException.class})
    public ResponseEntity<ApiResponse<List<ErrorResponse>>> handleException(MethodArgumentNotValidException e) {
        List<ErrorResponse> validErrorResponses = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> ErrorResponse.builder()
                        .errorField(fieldError.getField())
                        .errorMessage(fieldError.getDefaultMessage())
                        .inputValue(fieldError.getRejectedValue())
                        .build()
                ).toList();

        return exceptionResponse(e, BAD_REQUEST, VALID_EXCEPTION ,validErrorResponses);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
        return exceptionResponse(e, INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }

    // 실제 예외 처리 (log + 응답)
    private <T> ResponseEntity<ApiResponse<T>> exceptionResponse(Exception e, HttpStatus status, String message, T data) {
        log.warn(LOG_FORMAT, e.getClass().getSimpleName(), status, message);
        ApiResponse<T> response = ApiResponse.response(status, message, data);

        return ResponseEntity
                .status(status)
                .body(response);
    }
}
