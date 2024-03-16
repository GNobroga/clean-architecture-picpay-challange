package br.com.picpay.usecase;

import br.com.picpay.core.domain.TransactionPin;

public interface IUpdateTransactionPinUseCase {
    TransactionPin execute(TransactionPin transactionPin);
}
