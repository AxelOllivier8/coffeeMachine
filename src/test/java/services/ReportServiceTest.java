package services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import models.BeverageReport;
import models.Order;
import repositories.DaoReport;

class ReportServiceTest {

  ReportService reportService = new ReportService();
  OrderToMakerService orderToMakerService = new OrderToMakerService();
  Gson gson = new Gson();
  DaoReport dao = new DaoReport();
  @org.junit.jupiter.api.Test
  void printReport() {
    dao.resetDB();
    String report = reportService.printReport();
    BeverageReport br = new BeverageReport();
    Order order = new Order('O', 0,BigDecimal.valueOf(1),false);
    br.setChocolate(0);
    br.setCoffee(0);
    br.setOrange(0);
    br.setTea(0);
    br.setTotalCent(0);
    String expectedRes = gson.toJson(br);
    assertEquals(expectedRes, report);
    orderToMakerService.makingDrinks(order);
    br.setOrange(1);
    br.setTotalCent(60);
    expectedRes = gson.toJson(br);
    report = reportService.printReport();
    assertEquals(expectedRes, report);

  }

}
