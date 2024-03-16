package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.IConsultBalanceGateway;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.usecase.IConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCase implements IConsultBalanceUseCase  {

    private final IConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCase(IConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
