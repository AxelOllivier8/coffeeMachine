import java.math.BigDecimal;
import models.Order;
import services.OrderToMakerService;

public class MainApplication {

  private static OrderToMakerService orderToMakerService;

  public static void main(String[] args) {

    Order order = new Order(args[0].charAt(0), Integer.valueOf(args[1]), BigDecimal.valueOf(Double.valueOf(args[2])), Boolean.valueOf(args[3]));

    orderToMakerService = new OrderToMakerService();
    System.out.println(orderToMakerService.makingDrinks(order));
  }

}
