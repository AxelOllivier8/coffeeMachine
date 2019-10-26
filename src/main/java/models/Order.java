package models;

public class Order {

  private char orderType;

  private int nbSugar;

  private String messageContent;

  private double moneyGiven;

  public Order() {
  }

  public Order(char orderType, int nbSugar, double moneyGiven) {
    this.orderType = orderType;
    this.nbSugar = nbSugar;
    this.moneyGiven = moneyGiven;
  }

  public Order(char orderType, String messageContent, double moneyGiven) {
    this.orderType = orderType;
    this.messageContent = messageContent;
    this.moneyGiven = moneyGiven;
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

  public String getMessageContent() {
    return messageContent;
  }

  public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
  }

  public double getMoneyGiven() {
    return moneyGiven;
  }

  public void setMoneyGiven(double moneyGiven) {
    this.moneyGiven = moneyGiven;
  }
}
