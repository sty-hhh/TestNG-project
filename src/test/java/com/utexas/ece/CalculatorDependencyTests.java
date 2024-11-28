package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDependencyTests {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        int result = calculator.add(3, 2);
        Assert.assertEquals(result, 5, "Addition failed");
    }

    @Test(dependsOnMethods = {"testAddition"})
    public void testSubtraction() {
        int result = calculator.subtract(5, 2);
        Assert.assertEquals(result, 3, "Subtraction failed");
    }

    @Test(dependsOnMethods = {"testSubtraction"})
    public void testMultiplication() {
        int result = calculator.multiply(3, 2);
        Assert.assertEquals(result, 6, "Multiplication failed");
    }

    @Test(dependsOnMethods = {"testMultiplication"})
    public void testDivision() {
        int result = calculator.divide(6, 2);
        Assert.assertEquals(result, 3, "Division failed");
    }

}
