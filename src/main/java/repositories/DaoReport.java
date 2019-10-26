package repositories;

import static com.sun.activation.registries.LogSupport.log;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import models.BeverageReport;

public class DaoReport {

  private static Gson gson = new Gson();
  private static final String FILE_LOCATION = "src/main/resources/localDB.json";
  public DaoReport(){
  }

  public BeverageReport getReport() {
    File dataFile = new File(FILE_LOCATION);
    InputStreamReader isReader = null;
    try {
      isReader = new InputStreamReader(new FileInputStream(dataFile), "UTF-8");

      JsonReader myReader = new JsonReader(isReader);
      return  gson.fromJson(myReader, BeverageReport.class);

    } catch (Exception e) {
      log("Error loading data:  " + e.toString());
    } finally {
      try {
        isReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public void writeReport(BeverageReport report){
    File dataFile = new File(FILE_LOCATION);
    String reportString = gson.toJson(report);
    FileWriter fw = null;
    BufferedWriter bw = null;
    try {
      // Convenience class for writing character files
      fw = new FileWriter(dataFile.getAbsoluteFile(), false);

      // Writes text to a character-output stream
      bw = new BufferedWriter(fw);
      bw.write(reportString);
      bw.close();

    } catch (IOException e) {
      log("Error writing data: " + e.toString());
    }finally {
      try {
        bw.close();
        fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void resetDB(){
    BeverageReport br = new BeverageReport();
    writeReport(br);
  }

}
