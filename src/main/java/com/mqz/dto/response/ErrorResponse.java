package com.mqz.dto.response;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String errorMessage) {
}
