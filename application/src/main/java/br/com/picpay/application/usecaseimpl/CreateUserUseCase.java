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

    private ITaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private IEmailAvailableUseCase emailAvailableUseCase;

    private ICreateUserGateway createUserGateway;

    public CreateUserUseCase(ITaxNumberAvailableUseCase taxNumberAvailableUseCase, IEmailAvailableUseCase emailAvailableUseCase, ICreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        if (!taxNumberAvailableUseCase.validate(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if (!emailAvailableUseCase.validate(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if(!createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user),new TransactionPin(user, pin))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
