package testy.resources;

public class backendRequests {



    public static String pingPong = "{\"type\":\"ping\"}";
    public static String getPairs = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"pairs\"}]}";
    public static String BTC_USD_ob_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-USD\"}]}";
    public static String BTC_ETH_ob_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-ETH\"}]}";
    public static String BTC_EUR_ob_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-EUR\"}]}";
    public static String ETH_USD_ob_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"ETH-USD\"}]}";
    public static String ETH_EUR_ob_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"ETH-EUR\"}]}";
    public static String BTC_USD_candle_m1_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"candle_m1\",\"pair\":\"BTC-USD\"}]}";
    public static String BTC_ETH_candle_m1_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"candle_m1\",\"pair\":\"BTC-ETH\"}]}";
    public static String BTC_EUR_candle_m1_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"candle_m1\",\"pair\":\"BTC-EUR\"}]}";
    public static String ETH_USD_candle_m1_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"candle_m1\",\"pair\":\"ETH-USD\"}]}";
    public static String ETH_EUR_candle_m1_pair = "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"candle_m1\",\"pair\":\"ETH-EUR\"}]}";



}
