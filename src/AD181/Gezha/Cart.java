package AD181.Gezha;

import java.util.Stack;

class Cart {
  private Stack<Item> stack = new Stack<Item>();
  private int itemLimit;

  Cart(int maxItemsAmount) {
    this.itemLimit = maxItemsAmount;
  }

  boolean addItem(String name, float price) {
    if (this.stack.size() >= this.itemLimit) {
      return false;
    }
    this.stack.push(new Item(name, price));
    return true;
  }

  void removeItem() {
    if(this.stack.size() == 0) {
      return;
    }
    this.stack.pop();
  }

  int getItemLimit() {
    return this.itemLimit;
  }

  float getTotalPrice() {
    float totalPrice = 0.0f;
    for (Item item : this.stack) {
      totalPrice += item.getPrice();
    }
    return totalPrice;
  }

  void raisePrices(float percentile) {
    for (Item item : this.stack) {
      item.raisePrice(percentile);
    }
  }

  void lowerPrices(float percentile) {
    for (Item item : this.stack) {
      item.lowerPrice(percentile);
    }
  }
}
