public class ShoppingCartTests
{
    private ShoppingCart cart;


    [Test]
    public void TestAddItemToCart()
    {
        cart.AddItem(new Item("item1", 10.0));
        Assert.AreEqual(10.0, cart.TotalPrice);
    }

    [Test]
    public void TestRemoveItemFromCart()
    {
        cart.AddItem(new Item("item1", 10.0));
        cart.RemoveItem(new Item("item1", 10.0));
        Assert.AreEqual(0.0, cart.TotalPrice);
    }

    [Test]
    public void TestAddDifferentItemToCart()
    {
        cart.AddItem(new Item("item1", 10.0));
        cart.AddItem(new Item("item2", 20.0));
        Assert.AreEqual(30.0, cart.TotalPrice);
    }

    [Test]
    public void TestRemoveSecondItemFromCart()
    {
        cart.AddItem(new Item("item1", 10.0));
        cart.AddItem(new Item("item2", 20.0));
        cart.RemoveItem(new Item("item2", 20.0));
        Assert.AreEqual(10.0, cart.TotalPrice);
    }
}
