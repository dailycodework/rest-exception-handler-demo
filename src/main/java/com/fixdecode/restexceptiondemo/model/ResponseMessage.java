package com.fixdecode.restexceptiondemo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
public class ResponseMessage {
    private Integer statusCode;
    private HttpStatus status;
    private Map<?, ?> data;
}
