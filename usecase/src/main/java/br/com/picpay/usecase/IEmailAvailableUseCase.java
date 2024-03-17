package br.com.picpay.usecase;

import br.com.picpay.core.exception.EmailException;

public interface IEmailAvailableUseCase {
    boolean validate(String email) throws EmailException;

}
