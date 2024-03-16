package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.exception.*;

import java.math.BigDecimal;

public interface ITransferUseCase {
    boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException;
}
