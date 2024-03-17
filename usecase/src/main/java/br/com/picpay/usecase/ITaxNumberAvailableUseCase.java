package br.com.picpay.usecase;

import br.com.picpay.core.exception.TaxNumberException;

public interface ITaxNumberAvailableUseCase {
    boolean validate(String taxNumber) throws TaxNumberException;
}
