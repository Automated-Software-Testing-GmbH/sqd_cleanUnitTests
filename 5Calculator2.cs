using System;

public class Calculator
{
    public int Add(int a, int b)
    {
        if (a < 0 || b < 0)
        {
            throw new ArgumentException("Arguments must be positive integers");
        }

        return a + b;
    }
}


[TestFixture]
public class CalculatorTests
{
    [Test]
    public void TestAdd()
    {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.Add(2, 3);

        // Assert
        Assert.AreEqual(5, result);
    }
}