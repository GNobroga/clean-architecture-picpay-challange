package br.com.picpay.infrastructure.mapper;

import br.com.picpay.core.domain.TaxNumber;
import br.com.picpay.core.domain.User;
import br.com.picpay.infrastructure.dto.request.CreateUserRequest;
import br.com.picpay.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(User user) {
        return UserEntity
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .fullName(user.getFullName())
                .taxNumber(user.getTaxNumber().getValue())
                .type(user.getType())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
            request.email(),
            request.password(),
            new TaxNumber(request.taxNumber()),
            request.fullName(),
            request.type()
        );
    }
    public User toUser(UserEntity entity) throws Exception {
        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getPassword(),
                new TaxNumber(entity.getTaxNumber()),
                entity.getFullName(),
                entity.getType(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
