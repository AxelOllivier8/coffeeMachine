package utils;

public enum Beverage {
  COFFEE(0.6),
  TEA(0.4),
  CHOCO(0.5);

  double price;

  public double getPrice(){
    return this.price;
  }

  Beverage(double price){
    this.price = price;
  }
}
