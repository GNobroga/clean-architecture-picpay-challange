package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Transaction;

public interface ITransferGateway {

    boolean transfer(Transaction transaction);
}
