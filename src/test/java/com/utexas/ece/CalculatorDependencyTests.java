package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDependencyTests {
    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test(dependsOnMethods = {"testAddition"})
    public void testSubtraction() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test(dependsOnMethods = {"testSubtraction"})
    public void testMultiplication() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }

    @Test(dependsOnMethods = {"testMultiplication"})
    public void testDivision() {
        Assert.assertEquals(calculator.divide(6, 2), 3);
    }

}
