package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream;
        int size;
        while (true) {
            inputStream = new FileInputStream(reader.readLine());
            size = 0;
            while (inputStream.available() > 0) {
                inputStream.read();
                size++;
            }
            inputStream.close();
            if (size < 1000) break;
        }
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
