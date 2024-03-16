package br.com.picpay.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}
