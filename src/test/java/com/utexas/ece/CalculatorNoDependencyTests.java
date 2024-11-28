package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorNoDependencyTests {
    Calculator calculator = new Calculator();

    @Test(priority = 1)
    public void testAddition() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test(priority = 2)
    public void testSubtraction() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test(priority = 3)
    public void testMultiplication() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(priority = 4)
    public void testDivision() {
        Assert.assertEquals(calculator.divide(6, 2), 3);
    }
}
