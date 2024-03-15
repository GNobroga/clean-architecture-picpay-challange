package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.exception.TransferException;

public interface ICreateTransactionUseCase {

    Transaction create(Transaction transaction) throws TransferException;
}
