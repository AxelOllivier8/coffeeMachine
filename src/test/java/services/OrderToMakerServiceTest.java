package services;

import static org.junit.Assert.assertEquals;

import interfaces.BeverageQuantityChecker;
import java.math.BigDecimal;
import models.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderToMakerServiceTest {

  @Mock
  private BeverageQuantityChecker bqc;
  @InjectMocks
  private OrderToMakerService orderToMakerService;

  @Test
  public void makingDrinksEnoughMoney() {

    Mockito.when(bqc.isEmpty("T")).thenReturn(false);
    Mockito.when(bqc.isEmpty("H")).thenReturn(false);
    Mockito.when(bqc.isEmpty("C")).thenReturn(false);
    Mockito.when(bqc.isEmpty("O")).thenReturn(false);

    Order order1 = new Order('T',1, BigDecimal.valueOf(1), false);
    Order order2 = new Order('H',0,BigDecimal.valueOf(0.5), false);
    Order order3 = new Order('C',2,BigDecimal.valueOf(1), false);
    Order order4 = new Order('O',2,BigDecimal.valueOf(1), false);

    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);


    assertEquals("Wrong tea order","T:1:0",res1);
    assertEquals("Wrong chocolate order","H::",res2);
    assertEquals("Wrong coffee order","C:2:0",res3);
    assertEquals("Wrong orange juice order","O::",res4);

  }

  @Test
  public void makingDrinksNotEnoughMoney() {
    Mockito.when(bqc.isEmpty("T")).thenReturn(false);
    Mockito.when(bqc.isEmpty("H")).thenReturn(false);
    Mockito.when(bqc.isEmpty("C")).thenReturn(false);
    Mockito.when(bqc.isEmpty("O")).thenReturn(false);
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

  @Test
  public void makingDrinksHot() {
    Mockito.when(bqc.isEmpty("T")).thenReturn(false);
    Mockito.when(bqc.isEmpty("H")).thenReturn(false);
    Mockito.when(bqc.isEmpty("C")).thenReturn(false);
    Mockito.when(bqc.isEmpty("O")).thenReturn(false);
    Order order1 = new Order('T',1,BigDecimal.valueOf(1), true);
    Order order2 = new Order('H',0,BigDecimal.valueOf(0.7), true);
    Order order3 = new Order('C',2,BigDecimal.valueOf(0.9), true);
    Order order4 = new Order('O',0,BigDecimal.valueOf(0.6), true);
    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);


    assertEquals("Wrong tea order","Th:1:0",res1);
    assertEquals("Wrong chocolate order","Hh::",res2);
    assertEquals("Wrong coffee order","Ch:2:0",res3);
    assertEquals("Wrong orange juice order","O::",res4);

  }

  @Test
  public void beingShortOnMilk() {
    Mockito.when(bqc.isEmpty("T")).thenReturn(false);
    Mockito.when(bqc.isEmpty("H")).thenReturn(true);
    Mockito.when(bqc.isEmpty("C")).thenReturn(true);
    Mockito.when(bqc.isEmpty("O")).thenReturn(false);
    Order order1 = new Order('T',1,BigDecimal.valueOf(1), true);
    Order order2 = new Order('H',0,BigDecimal.valueOf(0.7), true);
    Order order3 = new Order('C',2,BigDecimal.valueOf(0.9), false);
    Order order4 = new Order('O',0,BigDecimal.valueOf(0.6), false);
    String res1 = orderToMakerService.makingDrinks(order1);
    String res2 = orderToMakerService.makingDrinks(order2);
    String res3 = orderToMakerService.makingDrinks(order3);
    String res4 = orderToMakerService.makingDrinks(order4);


    assertEquals("Wrong tea order","Th:1:0",res1);
    assertEquals("Wrong chocolate order","M:The is a shortage of water and/or milk.\n"
        + " A notification has been sent to the company in order to refill it.",res2);
    assertEquals("Wrong coffee order","M:The is a shortage of water and/or milk.\n"
        + " A notification has been sent to the company in order to refill it.",res3);
    assertEquals("Wrong orange juice order","O::",res4);

  }
}
