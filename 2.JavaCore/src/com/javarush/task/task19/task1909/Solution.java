package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        String fileContentLine = new String();
        while (inputBufferedReader.ready()) {
            fileContentLine = inputBufferedReader.readLine();
            fileWriter.write(fileContentLine.replace(".", "!"));
        }

        inputBufferedReader.close();
        bufferedWriter.close();
    }
}
