package br.com.picpay.usecase;

import br.com.picpay.core.domain.Transaction;
import br.com.picpay.core.exception.InternalServerErrorException;
import br.com.picpay.core.exception.NotFoundException;
import br.com.picpay.core.exception.NotificationException;
import br.com.picpay.core.exception.TransferException;

import java.math.BigDecimal;

public interface ITransferUseCase {
    boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException;
}
