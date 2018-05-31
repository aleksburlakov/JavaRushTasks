package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;
    private final int RUN_COUNT_ITERATION = 100;
    private final int COUNT_OF_EMPTY_LINE = 10;

    public Hippodrome() {}
    public  Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }
    public void run() {
        for (int i = 0; i < RUN_COUNT_ITERATION; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < COUNT_OF_EMPTY_LINE; ++i) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0.0;
        double currentHorseDistance = 0.0;
        for (Horse horse : horses) {
            currentHorseDistance = horse.getDistance();
            if (horse.getDistance() > maxDistance) {
                maxDistance = currentHorseDistance;
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {

        Hippodrome hippodrome = new Hippodrome();
        Horse horse1 = new Horse("A", 3, 0);
        Horse horse2 = new Horse("B", 3, 0);
        Horse horse3 = new Horse("C", 3, 0);

        List<Horse> horses = hippodrome.getHorses();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        Hippodrome.game = hippodrome;
        game.run();
        game.printWinner();
    }
}
