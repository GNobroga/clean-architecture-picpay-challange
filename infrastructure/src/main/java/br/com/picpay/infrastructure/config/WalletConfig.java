package br.com.picpay.infrastructure.config;

import br.com.picpay.application.gateway.*;
import br.com.picpay.application.usecaseimpl.*;
import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(IFindWalletByNumberGateway findWalletByNumberGateway) {
        return new FindWalletByNumberUseCase(findWalletByNumberGateway);
    }
    @Bean
    IConsultBalanceUseCase consultBalanceUseCase(IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCase(findWalletByTaxNumberUseCase);
    }

    @Bean
    ITransactionValidateUseCase transactionValidateUseCase(ITransactionValidateGateway transactionValidateGateway) {
        return new TransactionValidateUseCase(transactionValidateGateway);
    }

    @Bean
    ICreateTransactionUseCase createTransactionUseCase(ICreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionUseCase(createTransactionGateway);
    }

    @Bean
    IUserNotificationUseCase notificationUseCase(IUserNotificationGateway notificationGateway) {
        return new UserNotificationUseCase(notificationGateway);
    }


    @Bean
    IUpdateTransactionPinUseCase updateTransactionPinUseCase() {
        return new IUpdateTransactionPinUseCase() {
            @Override
            public TransactionPin execute(TransactionPin transactionPin) {
                return null;
            }
        };
    }

    @Bean
    ITransactionPinValidateUseCase transactionPinValidateUseCase(ITransactionPinValidateGateway transactionPinValidateGateway, IUpdateTransactionPinUseCase updateTransactionPinUseCase) {
        return new TransactionPinValidateUseCase(transactionPinValidateGateway, updateTransactionPinUseCase);
    }
    @Bean
    ITransferUseCase transferUseCase(ITransferGateway transferGateway) {
        return new TransferUseCase(transferGateway);
    }

}
