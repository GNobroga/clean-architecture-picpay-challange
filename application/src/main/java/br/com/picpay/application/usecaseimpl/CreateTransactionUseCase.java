package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ICreateTransactionGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.exception.TransferException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.ICreateTransactionUseCase;

public class CreateTransactionUseCase implements ICreateTransactionUseCase  {

    private ICreateTransactionGateway createTransactionGateway;
    @Override
    public Transaction create(Transaction transaction) throws TransferException {
        var transactionSaved = createTransactionGateway.create(transaction);

        if (transactionSaved == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
