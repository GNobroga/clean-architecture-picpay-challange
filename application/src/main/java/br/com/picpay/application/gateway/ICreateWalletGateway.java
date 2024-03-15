package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Wallet;

public interface ICreateWalletGateway {

    void create(Wallet wallet);
}
