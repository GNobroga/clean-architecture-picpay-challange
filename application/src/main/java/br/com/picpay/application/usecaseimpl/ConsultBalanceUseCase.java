package br.com.picpay.application.usecaseimpl;

import br.com.picpay.core.exception.NotFoundException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.IConsultBalanceUseCase;
import br.com.picpay.usecase.IFindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCase implements IConsultBalanceUseCase  {

    private final IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCase(IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        var wallet = findWalletByTaxNumberUseCase.find(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return wallet.getBalance();
    }
}
