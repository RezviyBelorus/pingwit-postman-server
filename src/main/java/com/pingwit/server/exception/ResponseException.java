package com.pingwit.server.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseException {
    private String message;
}
