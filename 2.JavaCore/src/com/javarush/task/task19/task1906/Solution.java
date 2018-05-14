package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first file name: ");
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        System.out.println("Enter second file name: ");
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());

        int count = 0;
        while (fileReader.ready()) {
            count++;
            char character = (char) fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(character);
            }
        }

        bufferedReader.close();
        fileReader.close();
        fileWriter.close();
    }
}
