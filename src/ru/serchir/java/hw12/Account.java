package ru.serchir.java.hw12;

public class Account {
    private static int currentAccountNumber;
    private final int accountNumber;

    public Account() {
        currentAccountNumber++;
        this.accountNumber = currentAccountNumber;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }
}
