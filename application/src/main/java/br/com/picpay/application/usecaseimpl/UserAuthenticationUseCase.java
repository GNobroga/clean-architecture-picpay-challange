package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.IUserAuthenticationGateway;
import br.com.picpay.core.exception.AuthenticationException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.IUserAuthenticateUseCase;
public class UserAuthenticationUseCase implements IUserAuthenticateUseCase  {

    private final IUserAuthenticationGateway userNotificationGateway;

    public UserAuthenticationUseCase(IUserAuthenticationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public boolean authenticate(String username, String password) throws AuthenticationException {
        if (!userNotificationGateway.authenticate(username, password)) {
            throw new AuthenticationException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }
        return true;
    }
}
