package models;

import java.math.BigDecimal;

public class Order {

  private char orderType;

  private int nbSugar;

  private BigDecimal moneyGiven;

  private boolean isExtraHot;

  public Order() {
  }

  public Order(char orderType, int nbSugar, BigDecimal moneyGiven, boolean isExtraHot) {
    this.orderType = orderType;
    this.nbSugar = nbSugar;
    this.moneyGiven = moneyGiven;
    this.isExtraHot = isExtraHot;
  }

  public char getOrderType() {
    return orderType;
  }

  public void setOrderType(char orderType) {
    this.orderType = orderType;
  }

  public int getNbSugar() {
    return nbSugar;
  }

  public void setNbSugar(int nbSugar) {
    this.nbSugar = nbSugar;
  }

  public BigDecimal getMoneyGiven() {
    return moneyGiven;
  }

  public void setMoneyGiven(BigDecimal moneyGiven) {
    this.moneyGiven = moneyGiven;
  }

  public boolean isExtraHot() {
    return isExtraHot;
  }

  public void setExtraHot(boolean extraHot) {
    isExtraHot = extraHot;
  }
}
