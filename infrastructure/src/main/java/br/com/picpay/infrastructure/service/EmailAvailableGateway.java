package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.IEmailAvailableGateway;
import br.com.picpay.application.gateway.ITaxNumberAvailableGateway;
import br.com.picpay.infrastructure.entity.UserEntity;
import br.com.picpay.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import static br.com.picpay.infrastructure.utils.Utilities.log;

@Service
@RequiredArgsConstructor
public class EmailAvailableGateway implements IEmailAvailableGateway {

    private final UserEntityRepository userEntityRepository;

    @Override
    public boolean validate(String email) {
        log.info("Início da validação do email::EmailAvailableGateway");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();
        Example<UserEntity> example = Example.of(UserEntity.builder().email(email).build(), matcher);
        return !userEntityRepository.exists(example);
    }
}
