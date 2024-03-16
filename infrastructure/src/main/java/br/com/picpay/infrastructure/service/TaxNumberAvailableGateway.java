package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.ITaxNumberAvailableGateway;
import br.com.picpay.infrastructure.entity.UserEntity;
import br.com.picpay.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import static br.com.picpay.infrastructure.utils.Utilities.*;

@Service
@RequiredArgsConstructor
public class TaxNumberAvailableGateway implements ITaxNumberAvailableGateway  {

    private final UserEntityRepository userEntityRepository;
    @Override
    public boolean taxNumberAvailable(String taxNumber) {
        log.info("Início da verificação do taxNumber::TaxNumberAvailableGateway");
        UserEntity userEntity = UserEntity.builder().taxNumber(taxNumber).build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();
        Example<UserEntity> example = Example.of(userEntity, matcher);
        return !userEntityRepository.exists(example);
    }
}
