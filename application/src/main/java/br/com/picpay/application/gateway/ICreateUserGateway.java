package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.core.domain.User;
import br.com.picpay.core.domain.Wallet;

public interface ICreateUserGateway {
    boolean create(User record, Wallet wallet);
}
