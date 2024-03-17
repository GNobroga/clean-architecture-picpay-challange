package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.TransactionPin;

public interface ITransactionPinValidateGateway {

    boolean validate(TransactionPin transactionPin, String pin);
}
