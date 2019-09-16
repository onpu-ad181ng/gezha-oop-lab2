package AD181.Gezha;

class Item {
  private String name;
  private float price;

  Item(String initialName, float initialPrice) {
    this.name = initialName;
    this.price = initialPrice;
    this.checkPrice();
  }

  void raisePrice(float percentile) {
    float coefficient = 1 + percentile / 100;
    this.alterPrice(coefficient);
  }

  void lowerPrice(float percentile) {
    float coefficient = 1 - percentile / 100;
    this.alterPrice(coefficient);
  }

  float getPrice() {
    return this.price;
  }

  String getName() {
    return this.name;
  }

  private void alterPrice(float coefficient) {
    this.price = this.price * coefficient;
    this.checkPrice();
  }

  // resets price to 0 if it is < 0
  private void checkPrice() {
    if (this.price < 0) {
      this.price = 0.0f;
    }
  }
}
