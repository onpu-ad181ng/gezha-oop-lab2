package AD181.Gezha;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Cart cart = Main.createCart();
    Main.fillCart(cart);

    System.out.println("Total price: " + cart.getTotalPrice());
    cart.raisePrices(15);
    System.out.println("Total price after raising: " + cart.getTotalPrice());
    cart.lowerPrices(30);
    System.out.println("Total price after lowering: " + cart.getTotalPrice());
  }

  private static Cart createCart() {
    // requests item amount until an integer is given
    System.out.print("Input maximum items amount for the cart: ");
    Scanner console = new Scanner(System.in);
    while (!console.hasNextInt())
      console.nextLine();
    int itemAmount = console.nextInt();

    return new Cart(itemAmount);
  }

  private static void fillCart(Cart cart) {
    int itemLimit = cart.getItemLimit();
    System.out.println("Input " + itemLimit + " items");

    // fills the cart with entered items until it's full
    for (int i = 0; i < itemLimit; ++i) {
      Scanner console = new Scanner(System.in);
      System.out.println("Item " + (i + 1) + " / " + itemLimit);

      // requests name until a string is given
      System.out.print("Input new item name: ");
      String itemName = new String("");
      while (itemName.isEmpty())
        itemName = console.nextLine();

      // requests price until a float is given
      System.out.print("Input new item price: ");
      while (!console.hasNextFloat())
        console.nextLine();
      float itemPrice = console.nextFloat();

      // adds the item to cart, messages user on fail
      boolean operationSuccessful = cart.addItem(itemName, itemPrice);
      if (!operationSuccessful) {
        System.out.println("Failed to add new item (cart is full)");
      }
    }
  }
}
