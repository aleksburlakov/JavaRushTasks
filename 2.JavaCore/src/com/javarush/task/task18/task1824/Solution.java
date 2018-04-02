package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            FileInputStream fileInputStream = null;
            String fileName = bufferedReader.readLine();
            try {
                fileInputStream = new FileInputStream(fileName);
                fileInputStream.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println(fileName);
                bufferedReader.close();
                break;
            }
        }
    }
}
