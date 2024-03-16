package br.com.picpay.infrastructure.dto.request;

import br.com.picpay.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullName, UserTypeEnum type, String pin) {
}
