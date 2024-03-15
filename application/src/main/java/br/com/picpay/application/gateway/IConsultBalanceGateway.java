package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Wallet;

import java.math.BigDecimal;

public interface IConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);

}
