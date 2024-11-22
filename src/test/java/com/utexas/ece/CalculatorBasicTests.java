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
}
