package br.com.picpay.infrastructure.controller;


import br.com.picpay.core.domain.Transaction;
import br.com.picpay.infrastructure.dto.request.TransferRequest;
import br.com.picpay.infrastructure.dto.response.BaseResponse;
import br.com.picpay.infrastructure.dto.response.ConsultBalanceResponse;
import br.com.picpay.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final IConsultBalanceUseCase consultBalanceUseCase;

    private final ITransferUseCase transferUseCase;

    private final ICreateTransactionUseCase createTransactionUseCase;

    private final IFindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    private final ITransactionValidateUseCase transactionValidateUseCase;

    private final ITransactionPinValidateUseCase transactionPinValidateUseCase;

    private final IUserNotificationUseCase userNotificationUseCase;

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        var fromWallet = findWalletByTaxNumberUseCase.find(transferRequest.fromTaxNumber());

        transactionPinValidateUseCase.validate(fromWallet.getTransactionPin(), transferRequest.pin());

        var toWallet = findWalletByTaxNumberUseCase.find(transferRequest.toTaxNumber());

        var transaction = createTransactionUseCase.create(fromWallet, toWallet, transferRequest.value());

        transactionValidateUseCase.validate(transaction);

        var result = transferUseCase.transfer(transaction);

        userNotificationUseCase.notificate(transaction, fromWallet.getUser().getEmail());

        var message = result ? "Transferência realizada com sucesso" : "Não foi possível realizar a transferência";
        return BaseResponse.<String>builder().success(result).message(message).build();
    }

}
