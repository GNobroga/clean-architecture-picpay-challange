package br.com.picpay.infrastructure.controller;


import br.com.picpay.infrastructure.dto.request.TransferRequest;
import br.com.picpay.infrastructure.dto.response.BaseResponse;
import br.com.picpay.infrastructure.dto.response.ConsultBalanceResponse;
import br.com.picpay.usecase.IConsultBalanceUseCase;
import br.com.picpay.usecase.ITransferUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final IConsultBalanceUseCase consultBalanceUseCase;

    private final ITransferUseCase transferUseCase;

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        var result = transferUseCase.transfer(transferRequest.fromTaxNumber(), transferRequest.toTaxNumber(), transferRequest.value(), transferRequest.pin());
        var message = result ? "Transferência realizada com sucesso" : "Não foi possível realizar a transferência";
        return BaseResponse.<String>builder().success(result).message(message).build();
    }

}
