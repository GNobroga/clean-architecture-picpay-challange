package br.com.picpay.usecase;

import br.com.picpay.core.exception.AuthenticationException;

public interface IUserAuthenticateUseCase {
    boolean authenticate(String username, String password) throws AuthenticationException;
}
