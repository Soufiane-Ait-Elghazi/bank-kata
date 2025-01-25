package org.skypay.bankkata.enums;

public enum ErrorCode {
    INVALID_AMOUNT("The transaction amount must be greater than zero."),
    INSUFFICIENT_FUNDS("Insufficient funds for the withdrawal."),
    PRINT_STATEMENT_HEADER("Date            || Amount   || Balance"),
    STATEMENT_FORMAT("%-15s || %-8s || %-8s");


    private final String text;
    ErrorCode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
