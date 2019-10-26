package utils;

import java.math.BigDecimal;

public enum Beverage {
  COFFEE(BigDecimal.valueOf(0.6)),
  TEA(BigDecimal.valueOf(0.4)),
  CHOCO(BigDecimal.valueOf(0.5)),
  ORANGE(BigDecimal.valueOf(0.6));

  BigDecimal price;

  public BigDecimal getPrice(){
    return this.price;
  }

  Beverage(BigDecimal price){
    this.price = price;
  }
}
