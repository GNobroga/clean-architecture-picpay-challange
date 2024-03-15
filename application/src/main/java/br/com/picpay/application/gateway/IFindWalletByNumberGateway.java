package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Wallet;

public interface IFindWalletByNumberGateway {
    Wallet findByTaxNumber(String taxNumber);
}
