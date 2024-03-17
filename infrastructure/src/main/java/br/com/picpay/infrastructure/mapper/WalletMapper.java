package br.com.picpay.infrastructure.mapper;

import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.core.domain.User;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.infrastructure.entity.TransactionPinEntity;
import br.com.picpay.infrastructure.entity.UserEntity;
import br.com.picpay.infrastructure.entity.WalletEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletMapper {

    private final UserMapper userMapper;

    private final TransactionPinMapper transactionPinMapper;

    public WalletEntity toEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPinEntity) {
        return WalletEntity.builder()
                .user(user)
                .balance(wallet.getBalance())
                .transactionPin(transactionPinEntity)
                .createdAt(wallet.getCreatedAt())
                .updatedAt(wallet.getUpdatedAt())
                .build();
    }


    public WalletEntity toEntity(Wallet wallet) {
        return WalletEntity.builder()
                .id(wallet.getId())
                .user(userMapper.toEntity(wallet.getUser()))
                .balance(wallet.getBalance())
                .transactionPin(transactionPinMapper.toEntity(wallet.getTransactionPin()))
                .createdAt(wallet.getCreatedAt())
                .updatedAt(wallet.getUpdatedAt())
                .build();
    }

    public Wallet toWallet(WalletEntity wallet, User user, TransactionPin transactionPin) {
        return new Wallet(
            wallet.getId(),
                transactionPin,
                wallet.getBalance(),
                user,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }

    public Wallet toWallet(WalletEntity wallet) throws Exception {
        return new Wallet(
                wallet.getId(),
                transactionPinMapper.toTransactionPin(wallet.getTransactionPin()),
                wallet.getBalance(),
                userMapper.toUser(wallet.getUser()),
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }
}
