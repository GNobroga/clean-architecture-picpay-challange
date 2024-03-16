package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.ICreateUserGateway;
import br.com.picpay.core.domain.User;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.infrastructure.mapper.TransactionPinMapper;
import br.com.picpay.infrastructure.mapper.UserMapper;
import br.com.picpay.infrastructure.mapper.WalletMapper;
import br.com.picpay.infrastructure.repository.TransactionPinEntityRepository;
import br.com.picpay.infrastructure.repository.UserEntityRepository;
import br.com.picpay.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.picpay.infrastructure.utils.Utilities.*;

@Service
@RequiredArgsConstructor
public class CreateUserGateway implements ICreateUserGateway {

    private final UserEntityRepository repository;

    private final UserMapper userMapper;

    private final TransactionPinMapper transactionPinMapper;

    private final WalletMapper walletMapper;

    private final TransactionPinEntityRepository transactionPinEntityRepository;

    private final WalletEntityRepository walletEntityRepository;



    @Override
    public boolean create(User record, Wallet wallet) {
       try {
           log.info("Início da criação do usuário::CreateUserGateway");
           var userSaved = repository.save(userMapper.toEntity(record));
           var transactionPin =  transactionPinMapper.toEntity((wallet.getTransactionPin()));
           var transactionPinSaved = transactionPinEntityRepository.save(transactionPin);
           walletEntityRepository.save(walletMapper.toEntity(wallet, userSaved, transactionPinSaved));
           log.info("Sucesso na criação do usuário::CreateUserGateway");
           return true;
       } catch (Exception e) {
           log.info("Houve um erro na criação do usuário::CreateUserGateway");
            return false;
       }
    }
}
