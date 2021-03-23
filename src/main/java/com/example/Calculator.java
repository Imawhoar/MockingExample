package com.example;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator
{
    int add(String numbers) throws RuntimeException {

        if(numbers.length() < 1)
            return 0;

        String delim = ",";

        numbers = numbers.replace("\n", "");

        //
        Pattern patternToExtractFormula;
        //Fråga inte, Adapt or Die
        Pattern patternToExtractDelimiters = Pattern.compile("(?<=\\[)(.*?)(?=\\])|(?<=//)(.)(?=[0-9])");
        Pattern patternToSplitParseFormula;
        if(numbers.startsWith("//"))
        {
            //Eftersom delimitern kanske blir mer än 1 char så kommer vi behöva manipulera en immutable sträng
            //Därför skapar vi en stringbuilder, som är mutable, för att effektivisera lite.
            StringBuilder delimBuilder = new StringBuilder();


            //löser ut alla delimiters som finns i början av argumentet -> //[.][;][..]x.xx;y..z == '.', ';', '..'
            Matcher delimiterMatch = patternToExtractDelimiters.matcher(numbers);

            int delimiterCount = 0;
            while (delimiterMatch.find())
            {
                ++delimiterCount;
                delimBuilder.append(delimiterMatch.group());
            }

            //Regex är knasig med syntaxen för hur delimiterna plockas upp.
            //[...] kräver inga brackets för att det räknas som HEL delimiter
            // vs [.][.][.] som behöver använda brackets i syntaxen för att plocka upp flera symboler.
            if(delimiterCount > 1)
                delim = "[" +delimBuilder.toString() + "]";
            else
                delim = delimBuilder.toString();
        }


        patternToExtractFormula = Pattern.compile("-?\\d+(\\s*"+delim+"\\s*-?\\d+)+$");
        Matcher match = patternToExtractFormula.matcher(numbers);
        if(!match.find())
            throw new RuntimeException("Format is wrong in formula");

        var extractedStringFormula = match.group();


        patternToSplitParseFormula = Pattern.compile(delim);
        var numberStream = patternToSplitParseFormula.splitAsStream(extractedStringFormula).mapToInt(Integer::parseInt);


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
        return patternToSplitParseFormula.splitAsStream(extractedStringFormula).mapToInt(Integer::parseInt).filter((value -> value<1000)).sum();
    }
}
