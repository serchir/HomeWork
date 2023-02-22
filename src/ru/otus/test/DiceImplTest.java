package ru.otus.test;

import ru.otus.assertions.Assertions;
import ru.otus.game.Dice;
import ru.otus.game.DiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DiceImplTest {

    public void testDiceImplResult() {

        String scenario = "Тест Dice возвращает значения 1-6";
        int testCount = 10;

        try {
            Dice testDice = new DiceImpl();
            List<Integer> testRes = new ArrayList();

            for (int i=0; i<testCount; i++) {
                testRes.add( i, testDice.roll());
            }

            for (Integer val : testRes) {
                Assertions.assertInInterval(1, 6, val);
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
