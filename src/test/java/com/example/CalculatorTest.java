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
    void NegativeAdditionTest(){
        Calculator calc = new Calculator();

        var formula = "-2,-51,6";
        var thrown = assertThrows(RuntimeException.class, () -> calc.add(formula));
        System.out.println(thrown.getMessage());
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

    @Test
    void Above1000AdditionTest()
    {
        Calculator calc = new Calculator();

        //10+520+310+5100+2+3+510 = 6455
        //10+520+310+(!5100)+2+3+510 = 1355
        var formula = "10,520,310,5100,2,3,510";
        assertEquals(1355, calc.add(formula));
        assertNotEquals(6455, calc.add(formula));
    }

    @Test
    void MultiDelimeterAdditionTest()
    {
        Calculator calc = new Calculator();

        var formula = "//[;;;]\n5;;;1;;;2";
        assertEquals(8, calc.add(formula));
        assertNotEquals(512, calc.add(formula));
    }
    @Test
    void VaryingDelimiterAdditionTest()
    {
        Calculator calc = new Calculator();

        //5+1+2+3+2+5 = 18
        var formula = "//[;][.][']\n5;1.2.3;2.5";
        assertEquals(18, calc.add(formula));
        assertNotEquals(512325, calc.add(formula));
    }

   /* @Test
    void MultiVaryingDelimiterAdditionTest()
    {
        Calculator calc = new Calculator();

        //5+15+3+1 = 24
        var formula = "//[;;][./]['.]\n5./15;;3'.1";
        assertEquals(24, calc.add(formula));
        assertNotEquals(512325, calc.add(formula));
    }*/
}
