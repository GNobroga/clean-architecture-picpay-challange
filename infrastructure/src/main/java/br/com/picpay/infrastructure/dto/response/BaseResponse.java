package br.com.picpay.infrastructure.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {

    private boolean success;

    private String message;

    private T result;

    private ErrorResponse error;
}
