package br.com.picpay.infrastructure.mapper;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.enums.TransactionStatusEnum;
import br.com.picpay.infrastructure.entity.TransactionEntity;
import br.com.picpay.infrastructure.entity.WalletEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final WalletMapper walletMapper;

    public TransactionEntity toEntity(Transaction src) {
        return TransactionEntity
                .builder()
                .id(src.getId())
                .fromWallet(walletMapper.toEntity(src.getFromWallet()))
                .toWallet(walletMapper.toEntity(src.getToWallet()))
                .transactionValue(src.getValue())
                .status(src.getStatus())
                .createdAt(src.getCreatedAt())
                .updatedAt(src.getUpdatedAt())
                .build();
    }

    public Transaction toTransaction(TransactionEntity src) throws Exception {
        return new Transaction(
                src.getId(),
                walletMapper.toWallet(src.getFromWallet()),
                walletMapper.toWallet(src.getToWallet()),
                src.getTransactionValue(),
                src.getStatus(),
                src.getCreatedAt(),
                src.getUpdatedAt()
        );
    }
}
