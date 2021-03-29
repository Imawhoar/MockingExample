package com.example;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String numbers) throws RuntimeException
    {
        int[] parsedNumbers = Pattern.compile("[^-?0-9]+")
                .splitAsStream(numbers).filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();

        var negativeArray = Arrays.stream(parsedNumbers).filter(value -> value < 0).toArray();
        if(negativeArray.length > 0)
            throw new RuntimeException(Arrays.toString(negativeArray));

        return Arrays.stream(parsedNumbers).filter(value -> value < 1000).sum();
    }
}
