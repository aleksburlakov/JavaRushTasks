package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);

        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        FileOutputStream outputStream = new FileOutputStream(file2);

        for (int i = list.size() - 1; i >= 0; --i) {
            outputStream.write(list.get(i));
        }

        inputStream.close();
        outputStream.close();
    }
}
