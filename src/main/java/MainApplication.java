import java.math.BigDecimal;
import models.Order;
import services.OrderToMakerService;
import services.ReportService;

public class MainApplication {

  private static OrderToMakerService orderToMakerService;
  private static ReportService reportService;

  public static void main(String[] args) {

    Order order = new Order(args[0].charAt(0), Integer.valueOf(args[1]), BigDecimal.valueOf(Double.valueOf(args[2])), Boolean.valueOf(args[3]));

    orderToMakerService = new OrderToMakerService();
    reportService = new ReportService();
    System.out.println(orderToMakerService.makingDrinks(order));
    System.out.println(reportService.printReport());
  }

}
