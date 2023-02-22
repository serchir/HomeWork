package ru.otus.test;

import ru.otus.assertions.Assertions;
import ru.otus.game.*;

public class GameTest {

    public void playGameTest1() {

        String scenario = "Тест Game проверка результата";

        try {
            String testWinner;
            Player test1 = new Player("Test1");
            Player test2 = new Player("Test2");

            Dice testDice = new FakeDiceIncrease();
            GameWinnerPrinterTest testWinnerPrinter = new GameWinnerPrinterTest();
            Game testGame = new Game(testDice, testWinnerPrinter);
            testGame.playGame(test1, test2);
            testWinner = testWinnerPrinter.getWinner().getName();

            Assertions.assertEquals(testWinner, "Test2");

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void playGameTest2() {

        String scenario = "Тест Game запуск с одинаковым результатом";

        try {
            String winner1;
            String winner2;
            Player test1 = new Player("Test1");
            Player test2 = new Player("Test2");

            Dice testDice = new FakeDiceOneResult();
            GameWinnerPrinterTest testWinnerPrinter = new GameWinnerPrinterTest();
            Game testGame = new Game(testDice, testWinnerPrinter);

            testGame.playGame(test1, test2);
            winner1 = testWinnerPrinter.getWinner().getName();
            testGame.playGame(test2, test1);
            winner2 = testWinnerPrinter.getWinner().getName();

            Assertions.assertEquals(winner1, winner2);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
    public void playGameTest3() {

        String scenario = "Тест Game запуск на одного игрока";

        try {
            Throwable actual = null;
            try {

                Dice dice = new DiceImpl();
                GameWinnerPrinterTest testWinnerPrinter = new GameWinnerPrinterTest();
                Game testGame = new Game(dice, testWinnerPrinter);
                Player test = new Player("Test");
                testGame.playGame(test, test);

            } catch (Throwable e) {
                actual = e;
            }

            if (actual == null) {
                throw new AssertionError("Given code does not throw any exception");
            } else {
                Assertions.assertEquals(Exception.class, actual.getClass());
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class FakeDiceOneResult implements Dice {
    public int roll() {
        return 1;
    }
}

class FakeDiceIncrease implements Dice {
    static int res = 0;
    @Override
    public int roll() {
        res++;
        return res;
    }
}

class GameWinnerPrinterTest implements GameWinnerPrinter {
    Player testWinner;
    @Override
    public void printWinner(Player winner) {
        this.testWinner = winner;
    }
    public Player getWinner() {
        return testWinner;
    }
}