package br.com.picpay.infrastructure.mapper;

import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.infrastructure.entity.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {

    public TransactionPinEntity toEntity(TransactionPin transactionPin) {
        return TransactionPinEntity.builder()
                .id(transactionPin.getId())
                .pin(transactionPin.getPin())
                .attempt(transactionPin.getAttempt())
                .blocked(transactionPin.isBlocked())
                .createdAt(transactionPin.getCreatedAt())
                .updatedAt(transactionPin.getUpdatedAt())
                .build();
    }

    public TransactionPin toTransactionPin(TransactionPinEntity entity) {
        return new TransactionPin(
                entity.getId(),
                entity.getPin(),
                entity.getAttempt(),
                entity.isBlocked(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
