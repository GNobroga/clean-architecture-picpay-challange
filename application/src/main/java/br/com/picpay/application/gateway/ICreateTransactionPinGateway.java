package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.TransactionPin;

public interface ICreateTransactionPinGateway {

    void create(TransactionPin transactionPin);
}
