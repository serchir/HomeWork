package ru.serchir.java.hw12;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Bank {
    private HashMap<Account, Client> accountClient = new HashMap<>();
    public Bank() {
    }

    public void linkClientAccount(Account account, Client client) {
        this.accountClient.put(account, client);
    }

    public Set<Account> getAccounts(Client client){
        Set<Account> accounts = new HashSet<>();
        for(HashMap.Entry entry : this.accountClient.entrySet()) {
            if (entry.getValue().equals(client))
                accounts.add((Account)entry.getKey());
        }
        return accounts;
    }

    public Client findClient(Account account) {
        return this.accountClient.get(account);
    }
}
