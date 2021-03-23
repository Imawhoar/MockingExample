package com.example;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator
{
    int add(String numbers) throws RuntimeException {

        String delim = ",";
        if(numbers.length()<1)
            return 0;

        numbers = numbers.replace("\n", "");

        if(numbers.startsWith("//"))
        {
            //Eftersom Delim är mer än 1 char så kommer vi behöva manipulera en immutable sträng
            //Därför skapar vi en stringbuilder, som är mutable, för att effektivisera lite.
            StringBuilder stringBuilder = new StringBuilder();

            //Vi vet att den tredje char är delimen så vi börjar där
            char firstDelim = numbers.charAt(2);

            for (int i = 2; i < numbers.length(); i++)
            {
                if(numbers.charAt(i) == firstDelim)
                    stringBuilder.append(firstDelim);

                //Om vi inte stoppar loopen när den träffar en siffra kommer den att plocka upp delimiters mellan siffrorna.
                if(Character.isDigit(numbers.charAt(i)))
                    break;
            }
            delim = stringBuilder.toString();
            numbers = numbers.substring(2 + stringBuilder.length());
        }
        Pattern compiledPattern = Pattern.compile(delim);

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
        return compiledPattern.splitAsStream(numbers).mapToInt(Integer::parseInt).filter((value -> value<1000)).sum();
    }
}
