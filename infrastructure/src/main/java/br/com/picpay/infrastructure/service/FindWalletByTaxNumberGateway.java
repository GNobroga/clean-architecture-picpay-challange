package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.IFindWalletByNumberGateway;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.infrastructure.entity.WalletEntity;
import br.com.picpay.infrastructure.mapper.TransactionPinMapper;
import br.com.picpay.infrastructure.mapper.UserMapper;
import br.com.picpay.infrastructure.mapper.WalletMapper;
import br.com.picpay.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindWalletByTaxNumberGateway implements IFindWalletByNumberGateway {

    private final WalletEntityRepository walletEntityRepository;

    private final WalletMapper walletMapper;

    private final UserMapper userMapper;

    private final TransactionPinMapper transactionPinMapper;

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var walletOptional = walletEntityRepository.findByUserTaxNumber(taxNumber);
        if (walletOptional.isPresent()) {
            var wallet = walletOptional.get();
            var user = userMapper.toUser(wallet.getUser());
            var transactionPin = transactionPinMapper.toTransactionPin(wallet.getTransactionPin());
            return walletMapper.toWallet(wallet, user, transactionPin);
        }
        return null;
    }
}
