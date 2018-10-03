/**
 * 
 * @author Sami Jenedi
 * The Item class tests new items and different values.
 *
 */
public class Soda {
  
 private String name;
 private double price;
 private int quantity;
 private int ounces;
 
 public String getName()
 {
   return name;
 }

public double getPrice()
 {
   return price;
 }

public int getQuantity()
{
  return quantity;
}

public int getOunces()
{
  return ounces;
}

public void setName(String name)
 {
   this.name = name;
 }

public void setPrice(double price)
 {
    this.price = price;
    if (price < 0)
      this.price = 0;
 }

public void setQuantity(int quantity)
{
   this.quantity = quantity;
   if (quantity < 0)
     this.quantity = 0;
}

public void setOunces(int ounces)
{
   this.ounces = ounces;
   if (ounces < 0)
     this.ounces = 0;
}

public Soda() {
  setName("");
  setPrice(0);
  setQuantity(0);
  setOunces(0);
}

  public Soda(String name, double price, int quantity, int ounces) {
    setName(name);
    setPrice(price);
    setQuantity(quantity);
    setOunces(ounces);
  }

public void reduce(int amount) {
  if (amount > 0)
    quantity = quantity - amount; 
}

}
