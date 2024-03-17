package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITransferGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.domain.User;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.*;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.*;

import java.math.BigDecimal;

public class TransferUseCase implements ITransferUseCase  {

    private final ITransferGateway transferGateway;

    public TransferUseCase(ITransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }

    @Override
    public boolean transfer(Transaction transaction) throws Exception {
        transaction.getFromWallet().transferValue(transaction.getValue());
        transaction.getToWallet().receiveValue(transaction.getValue());

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return true;
    }
}
