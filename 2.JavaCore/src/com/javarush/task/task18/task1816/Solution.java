package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileInputStream inputStream = new FileInputStream(args[0]);
            int count = 0;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if((data >= Integer.valueOf('A') && data <= Integer.valueOf('Z'))
                        || (data >= Integer.valueOf('a') && data <= Integer.valueOf('z'))){
                    count++;
                }
            }
            System.out.println(count);
            inputStream.close();
        }
    }
}
