package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    //Инициализируем штучки
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inp = new FileInputStream(r.readLine());
        String res="";
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> reslist = new ArrayList<Integer>();
//пихаем байты в массив
        while(inp.available()>0)
        {
            int data = inp.read();
            list.add(data);
        }
//в count считаем кол-во каждого байта
        int[] count = new int[list.size()];
        for (int i=0; i<list.size(); i++)
        {
            count[i] = 0;
            for (int j = 0; j < list.size();j++)
            {
                if (list.get(i)==list.get(j)) count[i]++;
            }
        }
//определяем минимум
        int max = Integer.MIN_VALUE;
        for (int h: count)
        {
            if (h>max) max = h;
        }
//собираем байты с минимумом использования и без повторов
        for (int i = 0; i<list.size(); i++)
        {
            if (!reslist.contains(list.get(i))&&count[i]==max) reslist.add(list.get(i));
        }
        for (int y: reslist)
        {
            res = y + " ";
        }
        System.out.println(res);
        r.close();
        inp.close();

    }
}