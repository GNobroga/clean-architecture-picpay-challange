package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Transaction;

public interface ICreateTransactionGateway {
    Transaction create(Transaction transaction) throws Exception;
}
