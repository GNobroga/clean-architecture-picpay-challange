package br.com.picpay.infrastructure.dto.response;

import java.util.List;

public record ErrorResponse(String code, String message, List<ValidationError> validations) {}
