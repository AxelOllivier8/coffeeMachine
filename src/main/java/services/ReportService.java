package services;

import com.google.gson.Gson;
import java.math.BigDecimal;
import models.BeverageReport;
import repositories.DaoReport;
import utils.Beverage;

public class ReportService {

  Gson gson = new Gson();
  DaoReport dao = new DaoReport();

  public ReportService(){

  }

  public String printReport(){
    BeverageReport report = dao.getReport();
    return gson.toJson(report);
  }

  public void updateReport(char type){
    BeverageReport report = dao.getReport();
    int price;
    switch(type){
      case 'C':
        report.setCoffee(report.getCoffee()+1);
        price = Beverage.COFFEE.getPrice().multiply(BigDecimal.valueOf(100)).intValue();
        report.setTotalCent(report.getTotalCent()+price);
        break;
      case 'H':
        report.setChocolate(report.getChocolate()+1);
        price = Beverage.CHOCO.getPrice().multiply(BigDecimal.valueOf(100)).intValue();
        report.setTotalCent(report.getTotalCent()+price);
        break;
      case 'T':
        report.setTea(report.getCoffee()+1);
        price = Beverage.TEA.getPrice().multiply(BigDecimal.valueOf(100)).intValue();
        report.setTotalCent(report.getTotalCent()+price);
        break;
      case 'O':
        report.setOrange(report.getCoffee()+1);
        price = Beverage.ORANGE.getPrice().multiply(BigDecimal.valueOf(100)).intValue();
        report.setTotalCent(report.getTotalCent()+price);
        break;
      default:
        break;
    }
    dao.writeReport(report);
  }

}
