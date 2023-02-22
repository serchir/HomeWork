package ru.serchir.java.hw23;

import java.util.Scanner;

public class HomeWork23 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Введите сумму: ");

        while (!(input = scanner.next()).equals("exit")) {
            try {
                int inputInt = Integer.parseInt(input);

                Rubles rub = new Rubles();
                rub.addSum(inputInt);

                Dollars dol = new Dollars();
                dol.addSum(inputInt);

                System.out.println(rub.getSumAndCurrencyInWords());
                System.out.println(dol.getSumAndCurrencyInWords());

            } catch (Exception e) {
                System.out.println("Возникла ошибка:" + e.getMessage() + "\nВведите другую сумму");
            }

        }

    }

}

