package services;

import interfaces.BeverageQuantityChecker;
import interfaces.EmailNotifier;
import java.math.BigDecimal;
import models.Order;
import stubs.BeverageQuantityCheckerStub;
import stubs.EmailNotifierStub;
import utils.Beverage;

public class OrderToMakerService {

  private static final String MISSING = "Missing ";

  private static final String EURO_FOR_YOUR = "€ for your ";

  private static final String COFFEE = "coffee.";

  private static final String TEA = "tea.";

  private static final String CHOCO = "chocolate.";

  private static final String ORANGE = "orange juice.";

  private static final String SHORTAGE = "The is a shortage of water and/or milk.\n A notification has been sent to the company in order to refill it.";

  private ReportService reportService = new ReportService();

  private BeverageQuantityChecker bqc;
  private EmailNotifier notifier;

  public OrderToMakerService(){
    this.bqc = new BeverageQuantityCheckerStub();
    this.notifier = new EmailNotifierStub();
  }

  public String makingDrinks(Order order){
    String result = "";
    String nbSugar = order.getNbSugar()==0 ? "" : String.valueOf(order.getNbSugar());
    Beverage beverage;
    BigDecimal moneyGiven = order.getMoneyGiven();
    boolean isEmpty;
    switch(order.getOrderType()){
      case 'C':
        beverage = Beverage.COFFEE;
        isEmpty = bqc.isEmpty("C");
        if (isEmpty){
          notifier.notifyMissingDrink("C");
          result = "M:"+ SHORTAGE;
        }else{
          if (moneyGiven.compareTo(beverage.getPrice())>=0){
            result = "C" + extraHot(order.isExtraHot()) + ":" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
            reportService.updateReport(order.getOrderType());
          } else {
            result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + COFFEE;
          }
        }
        break;
      case 'T':
        beverage = Beverage.TEA;
        isEmpty = bqc.isEmpty("T");
        if (isEmpty){
          notifier.notifyMissingDrink("T");
          result = "M:"+ SHORTAGE;
        }else{
          if (moneyGiven.compareTo(beverage.getPrice())>=0){
            result = "T" + extraHot(order.isExtraHot()) + ":" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
            reportService.updateReport(order.getOrderType());
          } else {
            result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + TEA;
          }
        }
        break;
      case 'H':
        beverage = Beverage.CHOCO;
        isEmpty = bqc.isEmpty("H");
        if (isEmpty){
          notifier.notifyMissingDrink("H");
          result = "M:"+ SHORTAGE;
        }else {
          if (moneyGiven.compareTo(beverage.getPrice())>=0){
            result = "H" + extraHot(order.isExtraHot()) + ":" + nbSugar + ":" + numberOfSticks(order.getNbSugar());
            reportService.updateReport(order.getOrderType());
          } else {
            result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + CHOCO;
          }
        }
        break;
      case 'O':
        beverage = Beverage.ORANGE;
        isEmpty = bqc.isEmpty("O");
        if (isEmpty){
          notifier.notifyMissingDrink("O");
          result = "M:"+ SHORTAGE;
        }else {
          if (moneyGiven.compareTo(beverage.getPrice())>=0){
            result = "O::";
            reportService.updateReport(order.getOrderType());
          } else {
            result = "M:"+ MISSING + (beverage.getPrice().subtract(moneyGiven)) + EURO_FOR_YOUR + ORANGE;
          }
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
