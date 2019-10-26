package services;

import java.math.BigDecimal;
import models.Order;
import utils.Beverage;

public class OrderToMakerService {

  private static final String MISSING = "Missing ";

  private static final String EURO_FOR_YOUR = "€ for your ";

  private static final String COFFEE = "coffee.";

  private static final String TEA = "tea.";

  private static final String CHOCO = "chocolate.";

  private static final String ORANGE = "orange juice.";

  ReportService reportService = new ReportService();

  public OrderToMakerService(){

  }

  public String makingDrinks(Order order){
    String result = "";
    String nbSugar = order.getNbSugar()==0 ? "" : String.valueOf(order.getNbSugar());
    Beverage beverage;
    BigDecimal moneyGiven = order.getMoneyGiven();

    switch(order.getOrderType()){
      case 'C':
        beverage = Beverage.COFFEE;
        if (moneyGiven.compareTo(beverage.getPrice())>=0){
          result = "C" + extraHot(order.isExtraHot()) + ":" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
          reportService.updateReport(order.getOrderType());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + COFFEE;
        }
        break;
      case 'T':
        beverage = Beverage.TEA;
        if (moneyGiven.compareTo(beverage.getPrice())>=0){
          result = "T" + extraHot(order.isExtraHot()) + ":" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
          reportService.updateReport(order.getOrderType());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + TEA;
        }
        break;
      case 'H':
        beverage = Beverage.CHOCO;
        if (moneyGiven.compareTo(beverage.getPrice())>=0){
          result = "H" + extraHot(order.isExtraHot()) + ":" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
          reportService.updateReport(order.getOrderType());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + CHOCO;
        }
        break;
      case 'O':
        beverage = Beverage.ORANGE;
        if (moneyGiven.compareTo(beverage.getPrice())>=0){
          result = "O::";
          reportService.updateReport(order.getOrderType());
        } else {
          result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + ORANGE;
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

  private String extraHot(boolean extraHot){
    return extraHot ? "h" : "";
  }

}
