package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "AdditionData")
    public Object[][] provideAdditionData() {
        return new Object[][]{
                {3, 2, 5},
                {-1, 4, 3},
                {0, 0, 0},
                {100, 200, 300}
        };
    }

    @Test(dataProvider = "AdditionData")
    public void testAddition(int a, int b, int expected) {
        Assert.assertEquals(calculator.add(a, b), expected);
    }

    @DataProvider(name = "DivisionData")
    public Object[][] provideDivisionData() {
        return new Object[][]{
                {6, 2, 3},
                {10, 5, 2},
                {0, 1, 0}
        };
    }

    @Test(dataProvider = "DivisionData")
    public void testDivision(int a, int b, int expected) {
        Assert.assertEquals(calculator.divide(a, b), expected);
    }
}
