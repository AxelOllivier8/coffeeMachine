package services;

import models.Order;
import utils.Beverage;

public class OrderToMakerService {

  private static final String MISSING = "Missing ";

  private static final String EURO_FOR_YOUR = "€ for your ";

  private static final String COFFEE = "coffee.";

  private static final String TEA = "tea.";

  private static final String CHOCO = "chocolate.";

  public OrderToMakerService(){

  }

  public String makingDrinks(Order order){
    String result = "";
    String nbSugar = order.getNbSugar()==0 ? "" : String.valueOf(order.getNbSugar());
    Beverage beverage;
    double moneyGiven = order.getMoneyGiven();
    switch(order.getOrderType()){
      case 'C':
        beverage = Beverage.COFFEE;
        if (moneyGiven>=beverage.getPrice()){
          result = "C:" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice()-moneyGiven) + EURO_FOR_YOUR + COFFEE;
        }
        break;
      case 'T':
        beverage = Beverage.TEA;
        if (moneyGiven>=beverage.getPrice()){
          result = "T:" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice()-moneyGiven) + EURO_FOR_YOUR + TEA;
        }
        break;
      case 'H':
        beverage = Beverage.CHOCO;
        if (moneyGiven>=beverage.getPrice()){
          result = "H:" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice()-moneyGiven) + EURO_FOR_YOUR + CHOCO;
        }
        break;
      default:
        break;
    }
    return result;
  }
  private String numberOfSticks(int nbSugar){
    if (nbSugar>0){
      return "0";
    }else {
      return "";
    }
  }

}
