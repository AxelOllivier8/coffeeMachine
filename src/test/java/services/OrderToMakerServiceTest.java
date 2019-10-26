package services;

import static org.junit.jupiter.api.Assertions.*;

import models.Order;

class OrderToMakerServiceTest {

  OrderToMakerService orderToMakerService = new OrderToMakerService();

  @org.junit.jupiter.api.Test
  void makingDrinks() {
    Order order1 = new Order('T',1);
    Order order2 = new Order('H',0);
    Order order3 = new Order('C',2);
    Order order4 = new Order('M',"message-content");

    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);

    assertEquals("T:1:0",res1, "Wrong tea order");
    assertEquals("H::",res2, "Wrong chocolate order");
    assertEquals("C:2:0",res3, "Wrong coffee order");
    assertEquals("M:message-content",res4, "Wrong message display");
  }
}
