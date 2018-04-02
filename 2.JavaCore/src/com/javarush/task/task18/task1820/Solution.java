package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        StringBuilder numbers = new StringBuilder();

        while (fileInputStream.available() > 0) {
            numbers.append((char) fileInputStream.read());
        }

        String[] numbersList = numbers.toString().split(" ");
        numbers.setLength(0);
        for (int i = 0; i < numbersList.length; ++i) {
            numbers.append(Math.round(Float.parseFloat(numbersList[i])));
            numbers.append(" ");
        }
        numbers.deleteCharAt(numbers.length() - 1);

        for (int i = 0; i < numbers.length(); ++i) {
            fileOutputStream.write(numbers.charAt(i));
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
