package ru.serchir.java.hw23.test;

import ru.serchir.java.hw23.Currency;
import ru.serchir.java.hw23.Rubles;

public class Tests {

    public void TestRubles() {

        String scenario = "Тест Rubles";

        try {
            Rubles testRub = new Rubles();
            int testSum1 = 1;
            String testRes1;

            testRub.addSum(testSum1);
            testRes1 = testRub.getSumAndCurrencyInWords();

            Assertions.assertEquals("1 РУБЛЬ", testRes1);

            int testSum2 = 2;
            String testRes2;

            testRub.addSum(testSum2);
            testRes2 = testRub.getSumAndCurrencyInWords();

            Assertions.assertEquals("2 РУБЛЯ", testRes2);

            int testSum3 = 5;
            String testRes3;

            testRub.addSum(testSum3);
            testRes3 = testRub.getSumAndCurrencyInWords();

            Assertions.assertEquals("5 РУБЛЕЙ", testRes3);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void TestCurrency() {

        String scenario = "Тест Currency";

        try {
            CurrencyTest currencyTest = new CurrencyTest();

            int testSum1 = (int)(Math.random()*100+1)*100+1;
            String testRes1;

            currencyTest.addSum(testSum1);
            testRes1 = currencyTest.getSumAndCurrencyInWords();

            Assertions.assertEquals(testSum1 +" testRootTestEnd1", testRes1);

            int testSum2 = (int)(Math.random()*100+1)*100+4;
            String testRes2;

            currencyTest.addSum(testSum2);
            testRes2 = currencyTest.getSumAndCurrencyInWords();

            Assertions.assertEquals(testSum2 +" testRootTestEnd2", testRes2);

            int testSum3 = (int)(Math.random()*100+1)*100+18;
            String testRes3;

            currencyTest.addSum(testSum3);
            testRes3 = currencyTest.getSumAndCurrencyInWords();

            Assertions.assertEquals(testSum3 +" testRootTestEnd3", testRes3);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}

class CurrencyTest extends Currency {
    CurrencyTest() {
        super("testRoot", "TestEnd1","TestEnd2","TestEnd3");
    }
}