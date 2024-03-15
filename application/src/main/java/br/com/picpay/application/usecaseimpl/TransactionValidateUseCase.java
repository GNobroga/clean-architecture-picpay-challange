package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITransactionValidateGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.exception.TransferException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.ITransactionValidateUseCase;

public class TransactionValidateUseCase implements ITransactionValidateUseCase {

    private ITransactionValidateGateway transactionValidateGateway;

    @Override
    public boolean validate(Transaction transaction) throws TransferException {
        if (transactionValidateGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }
}
