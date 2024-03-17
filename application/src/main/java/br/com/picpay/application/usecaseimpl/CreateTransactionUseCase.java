package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ICreateTransactionGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.TransferException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.ICreateTransactionUseCase;

import java.math.BigDecimal;

public class CreateTransactionUseCase implements ICreateTransactionUseCase  {

    private final ICreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCase(ICreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Wallet to, Wallet from, BigDecimal value) throws Exception {
        var transaction = new Transaction(from, to, value);

        if (from.getBalance().compareTo(value) < 0) {
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        var transactionSaved = createTransactionGateway.create(transaction);

        if (transactionSaved == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionSaved;
    }
}
