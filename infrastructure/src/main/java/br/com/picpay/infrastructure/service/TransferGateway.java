package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.ITransferGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.enums.TransactionStatusEnum;
import br.com.picpay.infrastructure.mapper.TransactionMapper;
import br.com.picpay.infrastructure.mapper.WalletMapper;
import br.com.picpay.infrastructure.repository.TransactionEntityRepository;
import br.com.picpay.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferGateway implements ITransferGateway {

    private final WalletEntityRepository walletEntityRepository;

    private final TransactionEntityRepository transactionEntityRepository;

    private final WalletMapper walletMapper;

    private final TransactionMapper transactionMapper;
    @Override
    @Transactional
    public boolean transfer(Transaction transaction) {
        try {
            walletEntityRepository.save(walletMapper.toEntity(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toEntity(transaction.getToWallet()));
            transaction.setStatus(TransactionStatusEnum.SUCCESS);
            transactionEntityRepository.save(transactionMapper.toEntity(transaction));
            return true;
        } catch (Exception e) {
            transaction.setStatus(TransactionStatusEnum.CANCELED);
            transactionEntityRepository.save(transactionMapper.toEntity(transaction));
            return false;
        }
    }
}
