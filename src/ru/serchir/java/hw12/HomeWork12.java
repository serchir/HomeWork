package ru.serchir.java.hw12;

import java.util.*;

public class HomeWork12 {

    public static void main(String[] args) {

        final int CLIENTS_COUNT = 3;
        final int ACCOUNTS_COUNT = 3;

        Bank myBank = new Bank();
        Map<String,Client> clients = new HashMap();
        Map<Integer,Account> accounts = new HashMap<>();

        for (int i=0; i<CLIENTS_COUNT; i++){
            String newClientName = "ClientTest"+(i+1);
            clients.put(newClientName,new Client(newClientName,18+i));
        }

        for (HashMap.Entry<String,Client> entry : clients.entrySet()) {
            for (int i=0; i<(int)(Math.random()*ACCOUNTS_COUNT+1); i++){
                Account newAccount = new Account();
                accounts.put(newAccount.getAccountNumber(),newAccount);
                myBank.linkClientAccount(newAccount,entry.getValue());
            }
        }

        System.out.println("Список клиентов");
        for (HashMap.Entry<String,Client> entry : clients.entrySet()) {
            System.out.println(entry.getValue().getName());
        }

        Scanner scanner = new Scanner(System.in);
        int intInput;
        String stringInput;

        System.out.println("Введите имя клиента для поиска счетов, номер счёта для поиска клиента, exit для выхода");

        while (true)
        {
            try {
                if (scanner.hasNextInt()) {

                    intInput = scanner.nextInt();
                    Client foundClient = myBank.findClient(accounts.get(intInput));
                    System.out.println("По номеру счёта " + intInput + " найден клиент " +  foundClient.getName());

                } else {
                    stringInput = scanner.next();
                    if (stringInput.equals("exit")) {
                        return;
                    } else {
                        Client inputClient = clients.get(stringInput);
                        Set<Account> foundAccounts = myBank.getAccounts(inputClient);
                        System.out.println("Список счетов клиента " + inputClient.getName());
                        for (Account val : foundAccounts) {
                            System.out.println(val.getAccountNumber());
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Возникла ошибка:" + e.getMessage());
            }

        }

    }
}

