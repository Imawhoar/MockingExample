package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void CommaAdditionTest(){
        Calculator calc = new Calculator();

        var formula = "4,5,1";
        assertEquals(10, calc.add(formula));
        assertNotEquals(0, calc.add(formula));

    }
    @Test
    void EmptyAdditionTest(){
        Calculator calc = new Calculator();

        var formula = "";
        assertEquals(0, calc.add(formula));
        assertNotEquals(Integer.MAX_VALUE, calc.add(formula));
    }
    @Test
    void BackSlashNAdditionTest(){
        Calculator calc = new Calculator();

        var formula = "15,2,\n3";
        assertEquals(20, calc.add(formula));
        assertNotEquals(Integer.MAX_VALUE, calc.add(formula));
    }

    @Test
    void ReplacementDelimiterAdditionTest()
    {
        Calculator calc = new Calculator();

        var formula = "//;\n15;2;3";
        assertEquals(20, calc.add(formula));
        assertNotEquals(Integer.MAX_VALUE, calc.add(formula));
    }
}
