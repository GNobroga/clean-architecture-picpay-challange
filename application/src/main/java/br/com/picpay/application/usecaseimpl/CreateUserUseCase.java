package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ICreateUserGateway;
import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.core.domain.User;
import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.exception.EmailException;
import br.com.picpay.core.exception.InternalServerErrorException;
import br.com.picpay.core.exception.TaxNumberException;
import br.com.picpay.core.exception.TransactionPinException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCase implements ICreateUserUseCase {

    private final ITaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private final IEmailAvailableUseCase emailAvailableUseCase;

    private final ICreateUserGateway createUserGateway;

    public CreateUserUseCase(ITaxNumberAvailableUseCase taxNumberAvailableUseCase, IEmailAvailableUseCase emailAvailableUseCase, ICreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        if(!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, new TransactionPin(pin) ,user))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
