package org.skypay.bankkata.enums;

public enum ErrorCode {
    INVALID_AMOUNT("The transaction amount must be greater than zero."),
    INSUFFICIENT_FUNDS("Insufficient funds for the withdrawal.");
    private final String text;
    ErrorCode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
