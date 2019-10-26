package services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import models.Order;

class OrderToMakerServiceTest {

  OrderToMakerService orderToMakerService = new OrderToMakerService();

  @org.junit.jupiter.api.Test
  void makingDrinksEnoughMoney() {
    Order order1 = new Order('T',1, BigDecimal.valueOf(1), false);
    Order order2 = new Order('H',0,BigDecimal.valueOf(0.5), false);
    Order order3 = new Order('C',2,BigDecimal.valueOf(1), false);
    Order order4 = new Order('O',2,BigDecimal.valueOf(1), false);

    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);


    assertEquals("T:1:0",res1, "Wrong tea order");
    assertEquals("H::",res2, "Wrong chocolate order");
    assertEquals("C:2:0",res3, "Wrong coffee order");
    assertEquals("O::",res4, "Wrong orange juice order");

  }

  @org.junit.jupiter.api.Test
  void makingDrinksNotEnoughMoney() {
    Order order1 = new Order('T',1,BigDecimal.valueOf(0.2), false);
    Order order2 = new Order('H',0,BigDecimal.valueOf(0.2), true);
    Order order3 = new Order('C',2,BigDecimal.valueOf(0.1), false);
    Order order4 = new Order('O',2,BigDecimal.valueOf(0.4), false);

    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);


    assertEquals("M:Missing 0.2€ for your tea.",res1);
    assertEquals("M:Missing 0.3€ for your chocolate.",res2);
    assertEquals("M:Missing 0.5€ for your coffee.",res3);
    assertEquals("M:Missing 0.2€ for your orange juice.",res4);

  }

  @org.junit.jupiter.api.Test
  void makingDrinksHot() {
    Order order1 = new Order('T',1,BigDecimal.valueOf(1), true);
    Order order2 = new Order('H',0,BigDecimal.valueOf(0.7), true);
    Order order3 = new Order('C',2,BigDecimal.valueOf(0.9), true);
    Order order4 = new Order('O',0,BigDecimal.valueOf(0.6), true);
    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);


    assertEquals("Th:1:0",res1, "Wrong tea order");
    assertEquals("Hh::",res2, "Wrong chocolate order");
    assertEquals("Ch:2:0",res3, "Wrong coffee order");
    assertEquals("O::",res4, "Wrong orange juice order");
  }
}
