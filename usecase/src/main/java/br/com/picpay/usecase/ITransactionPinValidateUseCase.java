package br.com.picpay.usecase;

import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.core.exception.PinException;
import br.com.picpay.core.exception.TransferException;

public interface ITransactionPinValidateUseCase {

    boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
