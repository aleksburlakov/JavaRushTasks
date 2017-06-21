package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);

        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        int size = list.size();
        int limit = size / 2;
        if (size % 2 == 1) {
            limit++;
        }
        FileOutputStream outputStream1 = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

        for (int i = 0; i < size; ++i) {
            if (i < limit) {
                outputStream1.write(list.get(i));
            } else {
                outputStream2.write(list.get(i));
            }
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
