package br.com.picpay.infrastructure.config;

import br.com.picpay.application.gateway.ICreateUserGateway;
import br.com.picpay.application.gateway.IEmailAvailableGateway;
import br.com.picpay.application.gateway.ITaxNumberAvailableGateway;
import br.com.picpay.application.usecaseimpl.CreateUserUseCase;
import br.com.picpay.application.usecaseimpl.EmailAvailableUseCase;
import br.com.picpay.application.usecaseimpl.TaxNumberAvailableUseCase;
import br.com.picpay.usecase.ICreateUserUseCase;
import br.com.picpay.usecase.IEmailAvailableUseCase;
import br.com.picpay.usecase.ITaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    IEmailAvailableUseCase emailAvailableUseCase(IEmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableUseCase(emailAvailableGateway);
    }
    @Bean
    ITaxNumberAvailableUseCase taxNumberAvailableUseCase(ITaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableUseCase(taxNumberAvailableGateway);
    }

    @Bean
    ICreateUserUseCase createUserUseCase(IEmailAvailableUseCase emailAvailableUseCase, ITaxNumberAvailableUseCase taxNumberAvailableUseCase, ICreateUserGateway createUserGateway) {
        return new CreateUserUseCase(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
