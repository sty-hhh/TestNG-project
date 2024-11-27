package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorBasicTests {
    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test(dependsOnMethods = {"testAddition", "testSubtraction"})
    public void testMultiplication() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calculator.divide(5, 0);
    }

    @Test
    public void testAdditionWithZero() {
        Assert.assertEquals(calculator.add(0, 5), 5);
        Assert.assertEquals(calculator.add(5, 0), 5);
    }

    @Test
    public void testSubtractionWithZero() {
        Assert.assertEquals(calculator.subtract(0, 5), -5);
        Assert.assertEquals(calculator.subtract(5, 0), 5);
    }

    @Test
    public void testMultiplicationWithZero() {
        Assert.assertEquals(calculator.multiply(0, 5), 0);
        Assert.assertEquals(calculator.multiply(5, 0), 0);
    }

    @Test
    public void testMultiplicationWithOne() {
        Assert.assertEquals(calculator.multiply(1, 5), 5);
        Assert.assertEquals(calculator.multiply(5, 1), 5);
    }

    @Test
    public void testDivisionWithOne() {
        Assert.assertEquals(calculator.divide(5, 1), 5);
    }

    @Test
    public void testDivideZeroByNumber() {
        // Confirm that dividing zero by a number returns zero without exception.
        Assert.assertEquals(calculator.divide(0, 5), 0);
    }

    @Test
    public void testNegativeMultiplication() {
        Assert.assertEquals(calculator.multiply(-2, 3), -6);
        Assert.assertEquals(calculator.multiply(2, -3), -6);
        Assert.assertEquals(calculator.multiply(-2, -3), 6);
    }

    @Test
    public void testNegativeDivision() {
        Assert.assertEquals(calculator.divide(-10, 2), -5);
        Assert.assertEquals(calculator.divide(10, -2), -5);
        Assert.assertEquals(calculator.divide(-10, -2), 5);
    }

    @Test
    public void testZeroAddition() {
        Assert.assertEquals(calculator.add(0, 0), 0);
    }

    @Test
    public void testZeroSubtraction() {
        Assert.assertEquals(calculator.subtract(0, 0), 0);
    }

    @Test
    public void testZeroMultiplication() {
        Assert.assertEquals(calculator.multiply(0, 0), 0);
    }

    @Test
    public void testNegativeAddition() {
        Assert.assertEquals(calculator.add(-5, -5), -10);
    }

    @Test
    public void testBoundaryValues() {
        Assert.assertEquals(calculator.add(Integer.MAX_VALUE, 0), Integer.MAX_VALUE);
        Assert.assertEquals(calculator.add(0, Integer.MAX_VALUE), Integer.MAX_VALUE);
        Assert.assertEquals(calculator.subtract(Integer.MIN_VALUE, 0), Integer.MIN_VALUE);
        Assert.assertEquals(calculator.subtract(0, Integer.MIN_VALUE), -Integer.MIN_VALUE); // Overflow boundary
    }
}
