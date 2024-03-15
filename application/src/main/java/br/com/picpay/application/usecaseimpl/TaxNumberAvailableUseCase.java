package br.com.picpay.application.usecaseimpl;

import br.com.picpay.application.gateway.ITaxNumberAvailableGateway;
import br.com.picpay.usecase.ITaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCase implements ITaxNumberAvailableUseCase  {

    private ITaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCase(ITaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public boolean validate(String taxNumber) {
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
