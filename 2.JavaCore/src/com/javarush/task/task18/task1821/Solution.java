package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);

            HashMap<Integer, Integer> charMap = new HashMap<>();

            while (fileInputStream.available() > 0) {
                int characterCode = fileInputStream.read();
                if (charMap.containsKey(characterCode)) {
                    int characterCodeCount = charMap.get(characterCode);
                    charMap.put(characterCode, ++characterCodeCount);
                } else {
                    charMap.put(characterCode, 1);
                }
            }
            fileInputStream.close();

            SortedMap<Integer, Integer> sortedMap = new TreeMap();
            sortedMap.putAll(charMap);

            for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
                ;
                System.out.println((char) entry.getKey().intValue() + " " + entry.getValue());
            }
        }
    }
}
