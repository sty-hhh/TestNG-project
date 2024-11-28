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

    @Test
    public void testAdditionOverflow() {
        int a = Integer.MAX_VALUE;
        int b = 1;
        try {
            calculator.add(a, b);
        } catch (ArithmeticException e) {
            Assert.assertTrue(e.getMessage().contains("overflow"));
        }
    }

    @Test
    public void testSubtractionUnderflow() {
        int a = Integer.MIN_VALUE;
        int b = 1;
        try {
            calculator.subtract(a, b);
        } catch (ArithmeticException e) {
            Assert.assertTrue(e.getMessage().contains("underflow"));
        }
    }

    @Test
    public void testDivisionPrecision() {
        // Ensure integer division handles flooring correctly.
        Assert.assertEquals(calculator.divide(7, 3), 2);
        Assert.assertEquals(calculator.divide(-7, 3), -2);
        Assert.assertEquals(calculator.divide(7, -3), -2);
        Assert.assertEquals(calculator.divide(-7, -3), 2);
    }

    @Test
    public void testLargeMultiplicationOverflow() {
        int a = 100000;
        int b = 100000;
        try {
            calculator.multiply(a, b);
        } catch (ArithmeticException e) {
            Assert.assertTrue(e.getMessage().contains("overflow"));
        }
    }

    @Test
    public void testMixedOperations() {
        // Test a sequence of operations to ensure consistency.
        int result = calculator.add(10, 5);
        result = calculator.subtract(result, 3);
        result = calculator.multiply(result, 2);
        result = calculator.divide(result, 6);
        Assert.assertEquals(result, 4);
    }

    @Test
    public void testCommutativeProperty() {
        // Test commutative property for addition and multiplication.
        Assert.assertEquals(calculator.add(10, 20), calculator.add(20, 10));
        Assert.assertEquals(calculator.multiply(10, 20), calculator.multiply(20, 10));
    }

    @Test
    public void testAssociativeProperty() {
        // Test associative property for addition and multiplication.
        Assert.assertEquals(calculator.add(calculator.add(10, 20), 30),
                calculator.add(10, calculator.add(20, 30)));
        Assert.assertEquals(calculator.multiply(calculator.multiply(10, 20), 30),
                calculator.multiply(10, calculator.multiply(20, 30)));
    }

    @Test
    public void testDistributiveProperty() {
        // Test distributive property: a * (b + c) == a * b + a * c.
        int a = 5, b = 3, c = 2;
        Assert.assertEquals(calculator.multiply(a, calculator.add(b, c)),
                calculator.add(calculator.multiply(a, b), calculator.multiply(a, c)));
    }

    @Test
    public void testNegativeAndZeroCombination() {
        // Test combining negative numbers and zeros in complex operations.
        int result = calculator.add(-10, 0);
        result = calculator.subtract(result, -5);
        result = calculator.multiply(result, -2);
        Assert.assertEquals(result, 10);
    }

    @Test
    public void testMultipleDivideByOne() {
        // Test multiple divisions by 1 to ensure no state retention issues.
        int result = calculator.divide(100, 1);
        result = calculator.divide(result, 1);
        result = calculator.divide(result, 1);
        Assert.assertEquals(result, 100);
    }

    @Test
    public void testChainedOperationsWithLargeNumbers() {
        // Simulate a real-world use case with chained large number operations.
        int result = calculator.add(100000, 200000);
        result = calculator.multiply(result, 2);
        result = calculator.subtract(result, 50000);
        result = calculator.divide(result, 3);
        Assert.assertEquals(result, 183333);
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
        int result = calculator.add(a, b);
        Assert.assertEquals(result, expected, "Addition failed");
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
        int result = calculator.divide(a, b);
        Assert.assertEquals(result, expected, "Division failed");
    }
}
