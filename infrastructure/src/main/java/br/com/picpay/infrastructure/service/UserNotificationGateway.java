package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.IUserNotificationGateway;
import br.com.picpay.core.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserNotificationGateway implements IUserNotificationGateway  {
    @Override
    public boolean notificate(Transaction transaction, String email) {
        //TODO implementar
        return true;
    }
}
