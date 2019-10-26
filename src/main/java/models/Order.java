package models;

public class Order {

  private char orderType;

  private int nbSugar;

  private String messageContent;

  public Order() {
  }

  public Order(char orderType, int nbSugar) {
    this.orderType = orderType;
    this.nbSugar = nbSugar;
  }

  public Order(char orderType, String messageContent) {
    this.orderType = orderType;
    this.messageContent = messageContent;
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
}
