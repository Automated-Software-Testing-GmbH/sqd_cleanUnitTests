[TestFixture]
public class LoginTests
{
    [Test]
    public void TestInvalidCredentialsErrorMessage()
    {
        // Arrange
        LoginService loginService = new LoginService();
        string username = "testuser";
        string password = "wrongpassword";

        // Act
        string errorMessage = loginService.Login(username, password);

        // Assert
        Assert.AreEqual("Invalid username or password", errorMessage);
    }
}
