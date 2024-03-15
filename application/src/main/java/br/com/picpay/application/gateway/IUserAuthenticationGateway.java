package br.com.picpay.application.gateway;

public interface IUserAuthenticationGateway {

    boolean authenticate(String username, String password);

}
