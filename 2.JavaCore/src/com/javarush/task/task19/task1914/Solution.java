package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        System.out.println(calculateExpression(result));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    public static String calculateExpression(String expression) {
        String[] expressionOperators = expression.split(" ");
        int leftOperand = Integer.parseInt(expressionOperators[0]);
        int rightOperand = Integer.parseInt(expressionOperators[2]);
        switch (expressionOperators[1]) {
            case "+":
                expression = expression + (leftOperand + rightOperand);
                break;
            case "*":
                expression = expression + (leftOperand * rightOperand);
                break;
            case "-":
                expression = expression + (leftOperand - rightOperand);
                break;
        }
        return expression.replaceAll("[\n\r]", "");
    }
}

