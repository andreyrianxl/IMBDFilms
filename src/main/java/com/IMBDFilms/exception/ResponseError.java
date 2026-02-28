package com.IMBDFilms.exception;

import java.time.LocalDate;
import java.util.List;

public class ResponseError {
    private String message;
    private Integer statusHttp;
    private LocalDate errorMoment;
    private List<String> errors;

    public ResponseError(String message, Integer statusHttp, LocalDate errorMoment) {
        this.message = message;
        this.statusHttp = statusHttp;
        this.errorMoment = errorMoment;
    }

    public ResponseError(String message, Integer statusHttp, LocalDate errorMoment, List<String> errors) {
        this.message = message;
        this.statusHttp = statusHttp;
        this.errorMoment = errorMoment;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusHttp() {
        return statusHttp;
    }

    public LocalDate getErrorMoment() {
        return errorMoment;
    }

    public List<String> getErrors() {
        return errors;
    }
}
