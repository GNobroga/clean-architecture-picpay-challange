package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.IEmailAvailableGateway;
import br.com.picpay.core.exception.EmailException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.IEmailAvailableUseCase;

public class EmailAvailableUseCase implements IEmailAvailableUseCase {

    private final IEmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCase(IEmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public boolean validate(String email) throws EmailException {
        if (!emailAvailableGateway.validate(email)) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        return true;
    }
}
