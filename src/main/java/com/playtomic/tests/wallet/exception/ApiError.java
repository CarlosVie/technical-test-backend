package com.playtomic.tests.wallet.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    Timestamp timestamp = new Timestamp(new Date().getTime());
    int status;
    String error;
    String message;

    public ApiError(String error, String errorMsg) {
        super();
        this.error = error;
        this.message = errorMsg;
    }
}
