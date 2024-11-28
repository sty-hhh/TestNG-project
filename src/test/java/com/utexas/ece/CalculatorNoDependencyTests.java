package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorNoDependencyTests {

    Calculator calculator = new Calculator();

    @Test(priority = 1)
    public void testAddition() {
        int result = calculator.add(3, 2);
        Assert.assertEquals(result, 5, "Addition failed");
    }

    @Test(priority = 2)
    public void testSubtraction() {
        int result = calculator.subtract(5, 2);
        Assert.assertEquals(result, 3, "Subtraction failed");
    }

    @Test(priority = 3)
    public void testMultiplication() {
        int result = calculator.multiply(3, 2);
        Assert.assertEquals(result, 6, "Multiplication failed");
    }

    @Test(priority = 4)
    public void testDivision() {
        int result = calculator.divide(6, 2);
        Assert.assertEquals(result, 3, "Division failed");
    }
}
