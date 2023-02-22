package ru.serchir.java.hw23;

public class Currency {
    private final String root;
    private final String end1;
    private final String end2;
    private final String end3;
    private int sum;
    private String currencyInWords;

    public Currency(String root, String end1, String end2, String end3) {
        this.root = root;
        this.end1 = end1;
        this.end2 = end2;
        this.end3 = end3;
    }

    public void addSum(int sum) {
        this.sum = sum;
        this.currencyInWords = addCurrencyInWords();
    }

    private String addCurrencyInWords() {
        return this.root + getEnd(this.sum);
    }

    private String getEnd(int sum) {

        int mod10 = sum % 10;
        int mod100 = sum % 100;

        if (mod100 >= 10 && mod100 <= 20) {
            return end3;
        }
        if (mod10 == 1) {
            return end1;
        }

        if (mod10 > 1 && mod10 < 5) {
            return end2;
        } else {
            return end3;
        }

    }

    public String getSumAndCurrencyInWords() {
        return this.sum + " " + this.currencyInWords;
    }
}
