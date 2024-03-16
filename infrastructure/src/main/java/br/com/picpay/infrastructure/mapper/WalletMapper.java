package br.com.picpay.infrastructure.mapper;

import br.com.picpay.core.domain.Wallet;
import br.com.picpay.infrastructure.entity.TransactionPinEntity;
import br.com.picpay.infrastructure.entity.UserEntity;
import br.com.picpay.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletEntity toEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPinEntity) {
        return WalletEntity.builder()
                .user(user)
                .balance(wallet.getBalance())
                .transactionPin(transactionPinEntity)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
