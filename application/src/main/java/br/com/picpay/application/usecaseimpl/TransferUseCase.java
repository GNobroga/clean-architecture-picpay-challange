package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITransferGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.*;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.*;

import java.math.BigDecimal;

public class TransferUseCase implements ITransferUseCase  {

    private final IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    private final ITransactionValidateUseCase transactionValidateUseCase;

    private final ICreateTransactionUseCase createTransactionUseCase;

    private final ITransferGateway transferGateway;

    private final IUserNotificationUseCase userNotificationUseCase;

    private final ITransactionPinValidateUseCase transactionPinValidateUseCase;

    public TransferUseCase(IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, ITransactionValidateUseCase transactionValidateUseCase, ICreateTransactionUseCase createTransactionUseCase, ITransferGateway transferGateway, IUserNotificationUseCase userNotificationUseCase, ITransactionPinValidateUseCase transactionPinValidateUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
    }

    @Override
    public boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws Exception {

        Wallet from = findWalletByTaxNumberUseCase.find(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.find(toTaxNumber);

        transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transferValue(value);
        to.receiveValue(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        transactionValidateUseCase.validate(transaction); // Validando através de um serviço externo

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.N0001.getMessage(), ErrorCodeEnum.N0001.getCode());
        }

        return true;
    }
}
