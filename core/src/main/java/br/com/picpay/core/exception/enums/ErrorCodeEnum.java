package br.com.picpay.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax Number invalid", "ON-0001"),
    ON0002("Tax number unavailable", "ON-0002"),
    ON0003("Email unavailable", "ON-0003"),
    ON0004("Error creating user", "ON-0004"),
    TR0001("The retail user does not have the ability to transfer", "TR-0001"),
    TR0002("Unavailable balance", "TR-0002"),
    TR0003("An error occurred while performing the transfer", "TR-0003"),
    TR0004("Unauthorized transfer", "TR-0004"),
    TRP0001("Pin invalid", "TRP-0001"),
    WA0001("Wallet not found", "WA-0001"),
    N0001("An error occurred while sending the notification to the recipient user", "N-0001"),
    ATH0001("An authentication error occurred", "ATH-0001");
    private String message;

    private String code;

    private ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
