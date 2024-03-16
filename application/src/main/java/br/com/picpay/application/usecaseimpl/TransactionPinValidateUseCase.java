package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITransactionPinValidateGateway;
import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.core.exception.PinException;
import br.com.picpay.core.exception.TransferException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.ITransactionPinValidateUseCase;
import br.com.picpay.usecase.IUpdateTransactionPinUseCase;

public class TransactionPinValidateUseCase implements ITransactionPinValidateUseCase {

    private final ITransactionPinValidateGateway transactionPinValidateGateway;

    private final IUpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCase(ITransactionPinValidateGateway transactionPinValidateGateway, IUpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public boolean validate(TransactionPin transactionPin) throws TransferException, PinException {
        if (transactionPin.isBlocked()) {
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

        if (!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.decreaseAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.execute(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3) {
            transactionPin.resetAttempt();
        }

        updateTransactionPinUseCase.execute(transactionPin);

        return true;
    }
}
