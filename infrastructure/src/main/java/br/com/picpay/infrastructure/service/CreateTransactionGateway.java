package br.com.picpay.infrastructure.service;


import br.com.picpay.application.gateway.ICreateTransactionGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.infrastructure.mapper.TransactionMapper;
import br.com.picpay.infrastructure.repository.TransactionEntityRepository;
import br.com.picpay.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static br.com.picpay.infrastructure.utils.Utilities.*;
@Service
@RequiredArgsConstructor
public class CreateTransactionGateway implements ICreateTransactionGateway  {

    private final TransactionEntityRepository transactionEntityRepository;

    private final TransactionMapper transactionMapper;

    private final WalletEntityRepository walletEntityRepository;


    @Override
    @Transactional
    public Transaction create(Transaction transaction) {
       try {
           log.info("Entrando no método para criar um create::CreateTransactionGateway");
           var transactionEntity = transactionMapper.toEntity(transaction);
           log.info("Carteiras associadas a transação create::CreateTransactionGateway");
           return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
       } catch (Exception e) {
           log.info("Ocorreu um erro ao criar a transação create::CreateTransactionGateway", e);
           return null;
       }
    }
}
