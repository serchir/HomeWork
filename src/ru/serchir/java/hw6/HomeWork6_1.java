package ru.serchir.java.hw6;

import java.util.Scanner;

public class HomeWork6_1 {
    private static final Object[][][] QUESTIONS_AND_ANSWERS =
            {
                    {
                            {"В файл с каким расширением компилируется java-файл?"},
                            {"cs","java","class","exe"},
                            {3}
                    },
                    {
                            {"С помощью какой команды git можно получить полную копию удаленного репозитория?"},
                            {"commit","push","clone","copy"},
                            {3}
                    },
                    {
                            {"Какой применяется цикл, когда не известно количество итераций?"},
                            {"while","for","loop"},
                            {3}
                    }
            };

    public static void main(String[] args) {

        int correctCount = 0;
        int wrongCount = 0;
        boolean result;

        for (int questionNumber = 0; questionNumber < QUESTIONS_AND_ANSWERS.length; questionNumber++) {

            printQuestionAndAnswers(questionNumber);

            result = scanAndCheckAnswer(questionNumber);

            if (result) {
                correctCount++;
            } else {
                wrongCount++;
            }

        }

        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);

    }

    private static void printQuestionAndAnswers(int questionNumber) {
        String question = (String)QUESTIONS_AND_ANSWERS[questionNumber][0][0];
        System.out.println(question);

        for (int answerNumber = 0; answerNumber < QUESTIONS_AND_ANSWERS[questionNumber][1].length; answerNumber++) {

            String answers = (String)QUESTIONS_AND_ANSWERS[questionNumber][1][answerNumber];
            System.out.println(answerNumber + 1 +": "+ answers);

        }
    }
    private static boolean scanAndCheckAnswer(int questionNumber) {
        System.out.println("\nВаш ответ: ");
        int answer;

        do {
            answer = scanAnswer(questionNumber);
        }
        while (answer < 0);

        if ((int)QUESTIONS_AND_ANSWERS[questionNumber][2][0] == answer-1) {
            System.out.println("Правильно \n");
            return true;
        } else {
            System.out.println("Неправильно \n");
            return false;
        }
    }
    private static int scanAnswer(int questionNumber) {
        int answer;
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            answer = scanner.nextInt();
            if (QUESTIONS_AND_ANSWERS[questionNumber][2].length < answer) {
                System.out.println("Выберите один из вариантов ответа \n");
                answer = -1;
            }
        } else {
            System.out.println("Выберите один из вариантов ответа \n");
            answer = -1;
        }
        return answer;
    }

}