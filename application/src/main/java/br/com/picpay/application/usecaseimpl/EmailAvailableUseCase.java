package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.IEmailAvailableGateway;
import br.com.picpay.usecase.IEmailAvailableUseCase;

public class EmailAvailableUseCase implements IEmailAvailableUseCase {

    private final IEmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCase(IEmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public boolean validate(String email) {
        return emailAvailableGateway.validate(email);
    }
}
