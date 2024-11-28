package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorGroupTests {

    Calculator calculator = new Calculator();

    @Test(groups = {"functional"})
    public void testAddition() {
        int result = calculator.add(3, 2);
        Assert.assertEquals(result, 5, "Addition failed");
    }

    @Test(groups = {"functional", "regression"})
    public void testSubtraction() {
        int result = calculator.subtract(5, 2);
        Assert.assertEquals(result, 3, "Subtraction failed");
    }

    @Test(groups = {"performance"})
    public void testMultiplication() {
        int result = calculator.multiply(3, 2);
        Assert.assertEquals(result, 6, "Multiplication failed");
    }

    @Test(groups = {"performance", "regression"})
    public void testDivision() {
        int result = calculator.divide(6, 2);
        Assert.assertEquals(result, 3, "Division failed");
    }
}
