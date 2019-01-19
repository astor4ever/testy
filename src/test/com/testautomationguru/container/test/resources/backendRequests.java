package com.testautomationguru.container.test.resources;

public class backendRequests {



    public static String pingPong = "{\"type\":\"ping\"}";
    public static String getPairs = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"pairs\"}]}";
    public static String BTC_USD_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-USD\"}]}";
    public static String BTC_ETH_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-ETH\"}]}";
    public static String BTC_EUR_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-EUR\"}]}";
    public static String ETH_USD_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"ETH-USD\"}]}";
    public static String ETH_EUR_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"ETH-EUR\"}]}";



}
