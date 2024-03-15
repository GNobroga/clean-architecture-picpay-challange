package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;

public interface IUserNotificationUseCase {
    boolean notificate(Transaction transaction, String email);
}
