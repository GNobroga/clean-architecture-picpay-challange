package br.com.picpay.infrastructure.service;


import br.com.picpay.application.gateway.ICreateTransactionGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.infrastructure.mapper.TransactionMapper;
import br.com.picpay.infrastructure.repository.TransactionEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTransactionGateway implements ICreateTransactionGateway  {

    private final TransactionEntityRepository transactionEntityRepository;

    private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public Transaction create(Transaction transaction) throws Exception {
       try {
           var transactionEntity = transactionMapper.toEntity(transaction);
           return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
       } catch (Exception e) {
           return null;
       }
    }
}
