package br.com.picpay.usecase;

import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.NotFoundException;

public interface IFindWalletByTaxNumberUseCase {

    Wallet find(String taxNumber) throws Exception;
}
