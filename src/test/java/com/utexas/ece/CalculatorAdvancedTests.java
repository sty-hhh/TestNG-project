package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorAdvancedTests {
    Calculator calculator = new Calculator();

    @Test
    public void testDivision() {
        Assert.assertEquals(calculator.divide(10, 2), 5);
    }

    @Test
    public void testNegativeNumbers() {
        Assert.assertEquals(calculator.add(-2, -3), -5);
        Assert.assertEquals(calculator.subtract(-5, -3), -2);
    }

    @Test
    public void testLargeNumbers() {
        Assert.assertEquals(calculator.multiply(1000, 2000), 2000000);
    }
}
