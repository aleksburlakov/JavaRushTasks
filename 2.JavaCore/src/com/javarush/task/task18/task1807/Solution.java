package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileStream = new FileInputStream(reader.readLine());
        int count = 0;
        while (fileStream.available() > 0) {
            if (fileStream.read() == 44) {
                count++;
            }
        }

        System.out.println(count);
        reader.close();
        fileStream.close();
    }
}
