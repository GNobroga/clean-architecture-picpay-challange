package br.com.picpay.infrastructure.client;

import br.com.picpay.infrastructure.client.dto.response.ApiValidateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiValidateService {

    private final ApiValidateClient apiValidateClient;

    public ApiValidateResponse validate() {
        try {
            return apiValidateClient.validate();
        } catch (Exception e) {
            return null;
        }
    }
}
