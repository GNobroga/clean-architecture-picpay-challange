package br.com.picpay.usecase;

import br.com.picpay.core.domain.User;
import br.com.picpay.core.exception.EmailException;
import br.com.picpay.core.exception.InternalServerErrorException;
import br.com.picpay.core.exception.TaxNumberException;
import br.com.picpay.core.exception.TransactionPinException;

public interface ICreateUserUseCase {

    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
