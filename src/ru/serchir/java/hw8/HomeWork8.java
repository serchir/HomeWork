package ru.serchir.java.hw8;

import java.util.Scanner;

public class HomeWork8 {

    private static QuestionsAndAnswers[] createQuestionsAndAnswers() {

        QuestionsAndAnswers[] questionsAndAnswers;

        String q1 = "В файл с каким расширением компилируется java-файл?";
        String[][] a1 = {{"cs","-"},{"java","-"},{"class","+"},{"exe","-"}};

        String q2 = "С помощью какой команды git можно получить полную копию удаленного репозитория?";
        String[][] a2 = {{"commit","-"},{"push","-"},{"clone","+"},{"copy","-"}};

        String q3 = "Какой применяется цикл, когда не известно количество итераций?";
        String[][] a3 = {{"while","+"},{"for","-"},{"loop","-"}};

        QuestionsAndAnswers questionsAndAnswers1 = new QuestionsAndAnswers(q1,a1);
        QuestionsAndAnswers questionsAndAnswers2 = new QuestionsAndAnswers(q2,a2);
        QuestionsAndAnswers questionsAndAnswers3 = new QuestionsAndAnswers(q3,a3);

        questionsAndAnswers = new QuestionsAndAnswers[]{questionsAndAnswers1, questionsAndAnswers2, questionsAndAnswers3};

        return questionsAndAnswers;
    }


    public static void main(String[] args) {

        int correctCount = 0;
        int wrongCount = 0;
        boolean result;

        QuestionsAndAnswers[] questionsAndAnswers = createQuestionsAndAnswers();

        int questionNumber = 0;
        while (questionNumber < questionsAndAnswers.length) {

            printQuestionAndAnswers(questionsAndAnswers[questionNumber]);

            result = scanAndCheckAnswer(questionsAndAnswers[questionNumber]);

            if (result) {
                correctCount++;
            } else {
                wrongCount++;
            }

            questionNumber++;
        }

        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);

    }


        private static void printQuestionAndAnswers(QuestionsAndAnswers questionsAndAnswers) {

            String question = questionsAndAnswers.getQuestion();
            Answer[] answers = questionsAndAnswers.getAnswers();

            System.out.println(question);

            for (int answerNumber = 0; answerNumber < answers.length; answerNumber++) {

                String answer = answers[answerNumber].getAnswer();
                System.out.println(answerNumber + 1 +": "+ answer);

            }
        }

        private static boolean scanAndCheckAnswer(QuestionsAndAnswers questionsAndAnswers) {
            System.out.println("\nВаш ответ: ");
            int answer;

            do {
                answer = scanAnswer(questionsAndAnswers);
            }
            while (answer < 0);

            if (questionsAndAnswers.answersOfQuestion[answer-1].isCorrect()) {
                System.out.println("Правильно \n");
                return true;
            } else {
                System.out.println("Неправильно \n");
                return false;
            }
        }
        private static int scanAnswer(QuestionsAndAnswers questionsAndAnswers) {
            int answer;
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (questionsAndAnswers.answersOfQuestion.length < answer) {
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


    class QuestionsAndAnswers {
        String question;
        Answer[] answersOfQuestion;

        private void addAnswer(String[][] answers) {

            Answer[] answersOfQuestion = new Answer[answers.length];

            for (int answerNumber = 0; answerNumber < answers.length; answerNumber++) {
                Answer newAnswer = new Answer(answers[answerNumber][0],answers[answerNumber][1].equals("+"));
                answersOfQuestion[answerNumber] = newAnswer;
            }
            this.answersOfQuestion = answersOfQuestion;
        }

        public QuestionsAndAnswers(String question, String[][] answers) {
            this.question = question;
            addAnswer(answers);
        }

        public String getQuestion() {
            return this.question;
        }

        public Answer[] getAnswers() {
            return this.answersOfQuestion;
        }
}

    class Answer {
        String answer;
        boolean correct;
        public Answer(String answer,boolean correct) {
            this.answer = answer;
            this.correct = correct;
        }

        public String getAnswer() {
            return answer;
        }

        public boolean isCorrect() {
            return correct;
        }
    }




