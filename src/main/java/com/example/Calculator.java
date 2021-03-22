package com.example;

import java.util.regex.Pattern;

public class Calculator
{
    int add(String numbers){

        String delim = ",";
        if(numbers.length()<1)
            return 0;

        if(numbers.contains("//"))
        {
            delim = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(3);
        }

        numbers = numbers.replace("\n", "");
        return Pattern.compile(delim).splitAsStream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
