package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.ITransactionValidateGateway;
import br.com.picpay.core.domain.Transaction;
import br.com.picpay.infrastructure.client.ApiValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionValidateGateway implements ITransactionValidateGateway {

    private final ApiValidateService apiValidateService;
    @Override
    public boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        return response != null && response.success() && "Autorizado".equalsIgnoreCase(response.message());
    }
}
