public class TemperatureConverter
{
    public double ConvertToFahrenheit(double celsius)
    {
        return celsius * 9 / 5 + 32;
    }
}

[TestFixture]
public class TemperatureConverterTests
{
    [Test]
    public void TestConversion()
    {
        // Arrange
        TemperatureConverter converter = new TemperatureConverter();

        // Act
        double result1 = converter.ConvertToFahrenheit(0);
        double result2 = converter.ConvertToFahrenheit(20);
        double result3 = converter.ConvertToFahrenheit(40);

        // Assert
        Assert.AreEqual(32, result1);
        Assert.AreEqual(68, result2);
        Assert.AreEqual(104, result3);
    }
}