package ru.serchir.java.hw14;

import java.io.FileOutputStream;
import java.util.Scanner;

public class HomeWork14 {

    private static final int MAX = 3;

    public static void main(String[] args) throws Exception {

        // вывод ошибки
        Scanner scanner = new Scanner(System.in);
        int length;
        int index;
        int myElement;

        MyInt myInt = new MyInt();

        System.out.println("Введите размерность массива");
        length = scanner.nextInt();
        MyRandomArray myArray1 = new MyRandomArray(length);
        System.out.println("Массив создан:");
        myArray1.printArray();

        for (int i = 1; i<=MAX ;i++) {
            System.out.println("Какой элемент массива запомнить распечатать?");
            index = scanner.nextInt();
            try {
                myElement = myArray1.getMyArrayElement(index);
                myInt.putMyIntValue(myElement);
                if (myInt.getVal() == myElement) {
                    System.out.println("Запомнено число: " + myInt.getVal());
                    break;
                }
            } catch (Exception e) {
                if (i < MAX) {
                System.out.println("Возникла ошибка:" + e.getMessage() + "\nПопробуйте ещё раз.");
                } else {
                    System.out.println("Попытки закончились. Запомнено число: " + myInt.getVal());
                }
            }
        }
        // вывод ошибки

        // Rethrow
        Scanner scanner2 = new Scanner(System.in);
        int val1;
        int result;

        try {
            System.out.println("Введите число для деления");
            val1 = scanner2.nextInt();

            try {
                result = myInt.getVal()/val1;

                System.out.println("Результат от деления запомненного числа на введённое: " + result);

            } catch (Exception e) {
                throw new Exception("Возникла ошибка деления", e);
            }
        } catch (Exception e) {
            throw new Exception("Возникла ошибка ввода данных", e);
        }
        // Rethrow

        // try-with-resource

        try (FileOutputStream output = new FileOutputStream("D:\\test.txt")) {
            {
                for (byte i = 1; i < result; i++) {
                    output.write(i);
                }
            }
        }

        // try-with-resource

    }
}


class MyRandomArray {
    int length;
    Integer[] array;

    MyRandomArray(int length) {
        this.array = new Integer[length];
        for(int i = 0; i< length; i++){
            this.array[i] = (int)(Math.random()*100+1);
        }
    }
    public void printArray() {
        for (int val : this.array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public Integer getMyArrayElement(Integer index) {
        return this.array[index - 1];
    }
}

class MyInt {
    int val;

    MyInt() {
    }

    MyInt (int val) {
        this.val = val;
    }

    public void putMyIntValue(int val) {
        this.val = val;
    }
    public int getVal() {
        return this.val;
    }

}
