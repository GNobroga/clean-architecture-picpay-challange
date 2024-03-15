package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Transaction;

public interface ITransactionValidateGateway {

    boolean validate(Transaction transaction);
}
