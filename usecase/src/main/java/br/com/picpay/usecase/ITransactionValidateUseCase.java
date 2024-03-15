package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.exception.TransferException;

public interface ITransactionValidateUseCase {

    boolean validate(Transaction transaction) throws TransferException;
}
