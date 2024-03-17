package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.TransferException;

import java.math.BigDecimal;

public interface ICreateTransactionUseCase {

    Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception;
}
