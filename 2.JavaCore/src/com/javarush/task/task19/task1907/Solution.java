package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name: ");
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();

        StringBuilder fileContentSB = new StringBuilder();

        while (fileReader.ready()) {
            fileContentSB.append(String.valueOf((char) fileReader.read()).toLowerCase());
        }

        fileReader.close();

        System.out.println(getCountOfSubstring(fileContentSB.toString(), "world"));
    }

    public static int getCountOfSubstring(String targetString, String subString) {
        String[] words = targetString.split("[^a-zA-Z0-9_\\-]");
        int counter = 0;
        for (String str : words) {
            str.trim();
            if (str.equals(subString))  {
                counter++;
            }
        }
        return counter;
    }
}
