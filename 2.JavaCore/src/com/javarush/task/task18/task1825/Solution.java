package com.javarush.task.task18.task1825;

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        Set fileNameSet = new TreeSet();

        for (fileName = bufferedReader.readLine(); !"end".equals(fileName); fileName = bufferedReader.readLine()) {
            fileNameSet.add(fileName);
        }

        bufferedReader.close();

        FileOutputStream fileOutputStream = null;
        String outputFileName = "";

        Iterator<String> iterator = fileNameSet.iterator();

        while(iterator.hasNext()) {
            fileName = iterator.next();
            if (!fileName.contains(outputFileName) || outputFileName.equals("")) {
                fileOutputStream = new FileOutputStream(fileName.substring(0, fileName.lastIndexOf(".")));
            }
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                int readCount = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, readCount);
            }
            fileInputStream.close();
        }

        bufferedReader.close();
        fileOutputStream.close();
    }
}
