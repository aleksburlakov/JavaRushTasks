package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maximum = 1;
        while (fileInputStream.available() > 0) {
            int value = fileInputStream.read();
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, 1);
            } else {
                int count = hashMap.get(value);
                count++;
                hashMap.put(value, count);
                if (count > maximum) {
                    maximum = count;
                }
            }
        }
        fileInputStream.close();

        // байтов с максимальным количеством повторов может быть несколько
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            int counter = (int) entry.getValue();
            if (counter == maximum) {
                resultArrayList.add((int) entry.getKey());
            }
        }

        for (Integer result : resultArrayList) {
            System.out.print(result + " ");
        }
    }
}
