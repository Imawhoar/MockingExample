package com.example;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator
{
    int add(String numbers) throws RuntimeException {

        String delim = ",";
        if(numbers.length()<1)
            return 0;

        if(numbers.contains("//"))
        {
            delim = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(3);
        }
        Pattern compiledPattern = Pattern.compile(delim);

        numbers = numbers.replace("\n", "");
        var numberStream = compiledPattern.splitAsStream(numbers).mapToInt(Integer::parseInt);


        //Check for negative values
        var negativeNumbers = numberStream.filter(number -> number < 0).toArray();
        if(negativeNumbers.length > 0)
        {
            if(negativeNumbers.length == 1)
                throw new RuntimeException("Negatives not allowed");

            throw new RuntimeException(Arrays.toString(negativeNumbers));
        }


        //Det går inte att en stream två gånger enligt docs.
        //Det verkar fortfarande effektivt med att skapa en stream istället för Collection metoderna
        return compiledPattern.splitAsStream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
