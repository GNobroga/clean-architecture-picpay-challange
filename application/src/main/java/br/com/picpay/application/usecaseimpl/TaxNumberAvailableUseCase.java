package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITaxNumberAvailableGateway;
import br.com.picpay.core.exception.TaxNumberException;
import br.com.picpay.core.exception.enums.ErrorCodeEnum;
import br.com.picpay.usecase.ITaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCase implements ITaxNumberAvailableUseCase  {

    private final ITaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCase(ITaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public boolean validate(String taxNumber) throws TaxNumberException {
        if (!taxNumberAvailableGateway.taxNumberAvailable(taxNumber)) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }
        return true;
    }
}
