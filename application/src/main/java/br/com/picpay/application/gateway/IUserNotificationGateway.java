package br.com.picpay.application.gateway;

import br.com.picpay.core.domain.Transaction;

public interface IUserNotificationGateway {

    boolean notificate(Transaction transaction, String email);
}
