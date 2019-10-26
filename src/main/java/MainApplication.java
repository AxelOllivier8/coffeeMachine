import models.Order;
import services.OrderToMakerService;

public class MainApplication {

  private static OrderToMakerService orderToMakerService;

  public static void main(String[] args) {

    int nbSugar;
    Order order;
    System.out.println(args[0] + " " + args[1]);
    if (!args[0].equals("M")){
      nbSugar = Integer.valueOf(args[1]);
      order = new Order(args[0].charAt(0), nbSugar);
    } else {
      order = new Order(args[0].charAt(0), args[1]);
    }
    orderToMakerService = new OrderToMakerService();
    System.out.println(orderToMakerService.makingDrinks(order));
  }

}
