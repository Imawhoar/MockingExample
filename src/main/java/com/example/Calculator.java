package com.example;

import java.util.regex.Pattern;

public class Calculator
{
    int add(String numbers){

        if(numbers.length()<1)
            return 0;

        numbers = numbers.replace("\n", "");
        return Pattern.compile(",").splitAsStream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
