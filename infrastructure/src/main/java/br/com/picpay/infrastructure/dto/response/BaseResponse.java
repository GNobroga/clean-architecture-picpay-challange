package br.com.picpay.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    private boolean success;

    private String message;

    private T result;

    private ErrorResponse error;
}
