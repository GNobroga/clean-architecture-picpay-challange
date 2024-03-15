package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITransferGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.InternalServerErrorException;
import br.com.picpay.core.exception.NotFoundException;
import br.com.picpay.core.exception.NotificationException;
import br.com.picpay.core.exception.TransferException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.*;

import java.math.BigDecimal;

public class TransferUseCase implements ITransferUseCase  {

    private IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    private ITransactionValidateUseCase transactionValidateUseCase;

    private ICreateTransactionUseCase createTransactionUseCase;

    private ITransferGateway transferGateway;

    private IUserNotificationUseCase userNotificationUseCase;

    public TransferUseCase(IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, ITransactionValidateUseCase transactionValidateUseCase, ICreateTransactionUseCase createTransactionUseCase, ITransferGateway transferGateway, IUserNotificationUseCase userNotificationUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @Override
    public boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException {

        Wallet from = findWalletByTaxNumberUseCase.find(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.find(toTaxNumber);

        from.transferValue(value);
        to.receiveValue(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.N0001.getMessage(), ErrorCodeEnum.N0001.getCode());
        }

        return true;
    }
}
