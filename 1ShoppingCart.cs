using System.Collections.Generic;

public class ShoppingCart
{
    public List<Product> Items { get; set; }

    public decimal TotalPrice => Items.Sum(item => item.Price);

    public void AddItem(Product product)
    {
        Items.Add(product);
    }
}

public class Product
{
    public string Name { get; set; }
    public decimal Price { get; set; }
}

[TestFixture]
public class ShoppingCartTests
{
    [Test]
    public void TestAddItem()
    {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product { Name = "Item 1", Price = 10 };
        cart.AddItem(product);

        Assert.AreEqual(1, cart.Items.Count);
        Assert.AreEqual(product, cart.Items[0]);
        Assert.AreEqual(10, cart.TotalPrice);
    }

    [Test]
    public void TestTotalPrice()
    {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product { Name = "Item 1", Price = 10 };
        Product product2 = new Product { Name = "Item 2", Price = 20 };
        cart.AddItem(product1);
        cart.AddItem(product2);

        Assert.AreEqual(2, cart.Items.Count);
        Assert.AreEqual(product1, cart.Items[0]);
        Assert.AreEqual(product2, cart.Items[1]);
        Assert.AreEqual(30, cart.TotalPrice);
    }
}