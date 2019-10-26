package services;

import models.Order;

public class OrderToMakerService {

  public OrderToMakerService(){

  }

  public String makingDrinks(Order order){
    String result = "";
    String nbSugar = order.getNbSugar()==0 ? "" : String.valueOf(order.getNbSugar());

    switch(order.getOrderType()){
      case 'C':
        result = result+"C:" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
        break;
      case 'T':
        result = result + "T:" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
        break;
      case 'H':
        result = result + "H:" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
        break;
      case 'M':
        result = result + "M:"+order.getMessageContent();
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
