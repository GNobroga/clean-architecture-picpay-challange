package br.com.picpay.usecase;

import br.com.picpay.core.domain.Wallet;

import java.math.BigDecimal;

public interface IConsultBalanceUseCase {
    BigDecimal consult(String taxNumber) throws Exception;
}


