package ru.serchir.java.hw12;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime* Objects.hash(accountNumber);
    }
}
