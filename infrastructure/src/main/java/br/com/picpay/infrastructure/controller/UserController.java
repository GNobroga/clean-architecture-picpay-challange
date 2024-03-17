package br.com.picpay.infrastructure.controller;

import br.com.picpay.infrastructure.dto.request.CreateUserRequest;
import br.com.picpay.infrastructure.dto.response.BaseResponse;
import br.com.picpay.infrastructure.mapper.UserMapper;
import br.com.picpay.usecase.ICreateUserUseCase;
import br.com.picpay.usecase.IEmailAvailableUseCase;
import br.com.picpay.usecase.ITaxNumberAvailableUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static  br.com.picpay.infrastructure.utils.Utilities.*;
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final ICreateUserUseCase createUserUseCase;

    private final IEmailAvailableUseCase emailAvailableUseCase;

    private final ITaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private final UserMapper userMapper;

    @PostMapping("/createUser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BaseResponse createUser(@RequestBody CreateUserRequest request) throws Exception {
        log.info("Início da criação do usuário::UserController");

        emailAvailableUseCase.validate(request.email());
        taxNumberAvailableUseCase.validate(request.taxNumber());

        createUserUseCase.create(userMapper.toUser(request), request.pin());
        return BaseResponse.<String>builder()
                .success(true)
                .message("Usuário criado com sucesso")
                .build();
    }
}
