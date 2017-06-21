package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();
        Set treeSet = new TreeSet<>();
        while (input.available() > 0) {
            treeSet.add(input.read());
        }

        for (Object i : treeSet)
        {
            System.out.print(i + " ");
        }

        reader.close();
        input.close();
    }
}
