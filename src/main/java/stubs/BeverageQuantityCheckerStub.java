package stubs;

import interfaces.BeverageQuantityChecker;

public class BeverageQuantityCheckerStub implements BeverageQuantityChecker {


  public boolean isEmpty(String drink){
    double rand = Math.random();
    return rand>0.75;
  }

}
