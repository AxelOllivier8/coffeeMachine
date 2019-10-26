package services;

import static org.junit.jupiter.api.Assertions.*;

import models.Order;

class OrderToMakerServiceTest {

  OrderToMakerService orderToMakerService = new OrderToMakerService();

  @org.junit.jupiter.api.Test
  void makingDrinksEnoughMoney() {
    Order order1 = new Order('T',1,1);
    Order order2 = new Order('H',0,0.5);
    Order order3 = new Order('C',2,1);
    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);

    assertEquals("T:1:0",res1, "Wrong tea order");
    assertEquals("H::",res2, "Wrong chocolate order");
    assertEquals("C:2:0",res3, "Wrong coffee order");
  }

  @org.junit.jupiter.api.Test
  void makingDrinksNotEnoughMoney() {
    Order order1 = new Order('T',1,0.2);
    Order order2 = new Order('H',0,0.2);
    Order order3 = new Order('C',2,0.1);
    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);

    assertEquals("M:Missing 0.2€ for your tea.",res1);
    assertEquals("M:Missing 0.3€ for your chocolate.",res2);
    assertEquals("M:Missing 0.5€ for your coffee.",res3);
  }
}
