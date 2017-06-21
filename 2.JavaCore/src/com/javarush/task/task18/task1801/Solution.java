package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        int maxData = file.read();
        while (file.available() > 0) {
            int data = file.read();
            if (data > maxData) {
                maxData = data;
            }
        }
        System.out.println(maxData);
        reader.close();
        file.close();
    }
}
