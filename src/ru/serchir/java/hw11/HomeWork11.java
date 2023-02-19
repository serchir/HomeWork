package ru.serchir.java.hw11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HomeWork11 {

    private static final Integer MAX_LIST_LENGTH = 10000;

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        List<Integer> myListForTest = new ArrayList<>();

        fillList(myList);
        myListForTest.addAll(myList);

        printList("Несортированный список:",myList);

        long start = new Date().getTime();
        selectionSort(myList);
        long end = new Date().getTime();
        System.out.println("Время работы selectionSort " + (end - start) + " мс");

        printList("Сортированный список:",myList);

        printList("myListForTest до сортировки:",myListForTest);

        start = new Date().getTime();
        Collections.sort(myListForTest);
        end = new Date().getTime();
        System.out.println("Время работы Collections.sort " + (end - start) + " мс");

        printList("myListForTest после сортировки:",myListForTest);

    }
    private static void printList(String text,List<Integer> list) {
        System.out.println(text);
        for(int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static void fillList(List<Integer> list) {
        for(int i = 0; i< MAX_LIST_LENGTH; i++){
            list.add((int)(Math.random()*1000));
        }
    }

    private static void selectionSort (List<Integer> list){
        int listSize = list.size();
        int minIndex;
        int minValue;
        for (int i=0;i<listSize-1;i++){
            minIndex = i;
            minValue = list.get(i);
            for (int j=i+1;j<listSize;j++) {
                if (minValue > list.get(j)) {
                    minValue = list.get(j);
                    minIndex = j;
                }
            }
            list.set(minIndex,list.get(i));
            list.set(i,minValue);
        }
    }

}