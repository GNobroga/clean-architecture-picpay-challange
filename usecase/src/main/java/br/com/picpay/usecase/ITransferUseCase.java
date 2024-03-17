package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.Wallet;

public interface ITransferUseCase {
    boolean transfer(Transaction transaction) throws Exception;
}
