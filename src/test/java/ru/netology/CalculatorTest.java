package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;
    final static int x = 10, y = 4;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void minusTest() {
        final int expected = 6;

        int result = calculator.minus.apply(x, y);

        assertEquals(expected, result);
    }

    @Test
    public void minusTest_notSuccess() {
        final int expected = 5;

        int result = calculator.minus.apply(x, y);

        assertNotEquals(expected, result);
    }

    @Test
    public void devideByZeroShouldHaveExeception() {
        final int a = 15, b = 0;

        ArithmeticException thrown = Assertions.assertThrows(
                ArithmeticException.class,
                () -> calculator.devide.apply(a, b),
                "Expected devide() to throw");

        assertTrue(thrown.getMessage().contains("/ by zero"));
    }

    @Test
    public void multiplyTest() {
        final int expected = 40;

        int result = calculator.multiply.apply(x, y);

        assertEquals(expected, result);
    }

    @Test
    public void plusTest() {
        final int expected = 14;

        int result = calculator.plus.apply(x, y);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @ValueSource (ints = { 1, 5, 7, 8 })
    public void testWithIntParameterPOW(int argument) {
        assertTrue(calculator.pow.apply(argument) == argument*argument);
    }

    @ParameterizedTest
    @ValueSource (ints = { 1, 5, 7, 8 })
    public void testWithIntParameterPOSITIVE(int argument) {
        assertTrue(calculator.isPositive.test(argument));
        assertFalse(calculator.isPositive.test(-argument));
    }


}


