package br.com.picpay.core.exception;

public class NotificationException extends Exception {

    private String code;

    public NotificationException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
