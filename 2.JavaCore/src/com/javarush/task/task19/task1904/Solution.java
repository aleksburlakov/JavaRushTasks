package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] rowColumn = fileScanner.nextLine().split(" ");
            return new Person(rowColumn[1], rowColumn[2], rowColumn[0],
                    new GregorianCalendar(Integer.parseInt(rowColumn[5]),
                            Integer.parseInt(rowColumn[4]) - 1,
                            Integer.parseInt(rowColumn[3])).getTime()
            );
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
