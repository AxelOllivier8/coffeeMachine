package services;



import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import interfaces.BeverageQuantityChecker;
import java.math.BigDecimal;
import models.BeverageReport;
import models.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import repositories.DaoReport;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest {


  @Mock
  private BeverageQuantityChecker bqc;
  @InjectMocks
  private OrderToMakerService orderToMakerService;

  private ReportService reportService = new ReportService();
  private Gson gson = new Gson();
  private DaoReport dao = new DaoReport();
  @Test
  public void printReport() {
    dao.resetDB();
    Mockito.when(bqc.isEmpty("O")).thenReturn(false);
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
