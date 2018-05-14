package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input file name: ");
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        System.out.println("Enter output file name: ");
        FileWriter fileWriter = new FileWriter(bufferedReader.readLine());
        bufferedReader.close();

        BufferedReader inputBufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder fileContent = new StringBuilder();
        while (inputBufferedReader.ready()) {
            fileContent.append(inputBufferedReader.readLine());
        }

        String[] words = fileContent.toString().split("[^a-zA-Zа-яА-Я0-9]");
        for (String word : words) {
            if (isNumber(word)) {
                bufferedWriter.write(word.concat(" "));
            }
        }

        inputBufferedReader.close();
        bufferedWriter.close();
    }

    public static boolean isNumber(String checkedString) {
        if (checkedString == null || checkedString.isEmpty()) {
            return false;
        }
        for (int i = 0; i < checkedString.length(); ++i) {
            char currentChar = checkedString.charAt(i);
            if (!(currentChar > '0' && currentChar < '9')) {
                return false;
            }
        }
        return  true;
    }
}
