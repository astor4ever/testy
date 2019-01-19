package com.testautomationguru.container.test.resources;

import java.util.ArrayList;
import java.util.List;

public class backendPatternRespons {



  public static List<String> pairsListPattern(){
      List<String> pairsList = new ArrayList<>();
      pairsList.add("BTC-USD");
      pairsList.add("BTC-ETH");
      pairsList.add("BTC-EUR");
      pairsList.add("ETH-USD");
      pairsList.add("ETH-EUR");
      return pairsList;
  }



}
