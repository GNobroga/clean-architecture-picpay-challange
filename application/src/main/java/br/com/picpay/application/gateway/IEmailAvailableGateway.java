package br.com.picpay.application.gateway;

public interface IEmailAvailableGateway {

    boolean validate(String email);
}
