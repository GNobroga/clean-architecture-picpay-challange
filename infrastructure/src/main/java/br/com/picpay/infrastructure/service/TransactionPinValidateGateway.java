package br.com.picpay.infrastructure.service;

import br.com.picpay.application.gateway.ITransactionPinValidateGateway;
import br.com.picpay.core.domain.TransactionPin;
import br.com.picpay.infrastructure.repository.TransactionPinEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TransactionPinValidateGateway implements ITransactionPinValidateGateway  {

    private final TransactionPinEntityRepository transactionPinEntityRepository;
    @Override
    public boolean validate(TransactionPin transactionPin) {
        if (transactionPin == null || transactionPin.getId() == null) {
            return false;
        }

        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());

        if (transactionPinSaved.isEmpty()) {
            return false;
        }
        //TODO validar isso depois
        if (!Objects.equals(transactionPin.getPin(), transactionPinSaved.get().getPin())) {
            return false;
        }

        return true;
    }
}
