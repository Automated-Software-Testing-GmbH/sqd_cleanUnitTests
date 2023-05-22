[TestFixture]
public class CalculatorTests
{
    [Test]
    public void TestCalculate()
    {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result;
        if (calculator.IsEven(2))
        {
            result = calculator.Add(1, 2);
        }
        else
        {
            result = calculator.Subtract(4, 2);
        }

        // Assert
        Assert.AreEqual(3, result);
    }
}
