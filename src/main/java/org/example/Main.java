package org.example;

import java.util.*;

public class Main {

    private static final Random random = new Random();
    private static final int ROUNDS = 1000;
    private static final int NUMBER_OF_DOORS = 3;

    private static final HashMap<Integer, Boolean> result = new HashMap<>();


    public static void main(String[] args) {

        int wins = 0;
        for (int i = 1; i < ROUNDS + 1; i++) {
            int prize = random.nextInt(NUMBER_OF_DOORS);
            int choice1 = random.nextInt(NUMBER_OF_DOORS);
            int gameHost = choosingTheDoor(prize, choice1);
            if(choice1 == prize){
                result.put(i, true);
            }
            int choice2 = choosingTheDoor(choice1, gameHost);
            if (choice2 == prize){
                result.put(i, true);
                wins ++;
            } else {
                result.put(i, false);
            }
            System.out.printf("Попытка: %d, результат: %b\n", i, result.get(i));
        }
        System.out.println("Количество побед при смене выбора: " + wins);
    }
    private static int choosingTheDoor(int door1, int door2){
        int result;
        do {
            result = random.nextInt(NUMBER_OF_DOORS);
        }
        while (result == door1 || result == door2);
        return result;
    }
}