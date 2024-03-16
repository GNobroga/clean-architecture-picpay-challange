package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.IFindWalletByNumberGateway;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.NotFoundException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.IFindWalletByTaxNumberUseCase;

public class FindWalletByNumberUseCase implements IFindWalletByTaxNumberUseCase {

    private final IFindWalletByNumberGateway findWalletByNumberGateway;

    public FindWalletByNumberUseCase(IFindWalletByNumberGateway findWalletByNumberGateway) {
        this.findWalletByNumberGateway = findWalletByNumberGateway;
    }

    @Override
    public Wallet find(String taxNumber) throws NotFoundException {
        var wallet = findWalletByNumberGateway.findByTaxNumber(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return wallet;
    }
}
