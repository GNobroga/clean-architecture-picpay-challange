package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.IUserNotificationGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.usecase.IUserNotificationUseCase;

public class UserNotificationUseCase implements IUserNotificationUseCase {

    private IUserNotificationGateway userNotificationGateway;

    public UserNotificationUseCase(IUserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
