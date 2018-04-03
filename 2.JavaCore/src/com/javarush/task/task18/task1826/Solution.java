package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    private static byte key = 10;

    public static void main(String[] args) throws IOException {
        if (args.length < 3) return;

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        while (fileInputStream.available() > 0) {
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            System.out.println(Arrays.toString(crypt(data)));
            fileOutputStream.write(crypt(data));
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    private static byte[] crypt(byte[] data) {
        byte[] res = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            res[i] = (byte)(data[i] ^ key);
        }

        return res;
    }
}
