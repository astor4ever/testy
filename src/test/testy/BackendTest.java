package testy;


import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testy.resources.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class BackendTest {

    private String ws = "s://dv.investimetric.io:5000/ws";
    Gson gson = new Gson();


    @Test(priority = -1)
    public void checkConnection() throws InterruptedException, URISyntaxException {
        ExampleClient client = new ExampleClient(new URI( ws ), backendRequests.pingPong);
        client.connectBlocking();
        Thread.sleep(3000);
        System.out.println(client.results);
        client.closeBlocking();
        assertTrue(client.results.contains("{\"type\":\"pong\"}\t"));
    }

    @Test(dependsOnMethods = {"checkConnection"})
    public void checkPairs() throws URISyntaxException, InterruptedException {
        ExampleClient  client = new ExampleClient(new URI( ws ), backendRequests.getPairs);
        client.connectBlocking();
        Thread.sleep(3000);
        System.out.println(client.results);
        client.closeBlocking();
        JSONObject json = new JSONObject(client.results.get(0));
        List changesList = new Gson().fromJson(json.getJSONArray("changes").toString(), List.class);
        List pairsResults = new ArrayList<>();
        for (Object listForPairs : changesList) {
            pairsResults.add(((LinkedTreeMap) listForPairs).get("id"));
        }
        System.out.println(pairsResults);
        Assert.assertEquals(pairsResults, backendPatternRespons.pairsListPattern());
    }

    @Test(dataProvider = "ob_pairs",dependsOnMethods = {"checkPairs"})
    public void checkEachPair(String pairs) throws URISyntaxException, InterruptedException {
        System.out.println("Checking: "+pairs);
        ExampleClient  client = new ExampleClient(new URI( ws ), pairs);
        client.connectBlocking();
        Thread.sleep(3000);
        System.out.println(client.results);
        client.closeBlocking();

        List<JSONObject> lol = new ArrayList<>();
        for(String element : client.results){
            lol.add(new JSONObject(element));
        }

        for(JSONObject element : lol){
            assertEquals(element.toMap().get("pair"),pairs.substring(53,60));
            System.out.println("Pair correct.");
        }
    }

    @Test(dataProvider = "ob_pairs",dependsOnMethods = {"checkPairs"})
    public void checkOBtypes(String pairs) throws URISyntaxException, InterruptedException {
        System.out.println("Checking: "+pairs);
        ExampleClient  client = new ExampleClient(new URI( ws ), pairs);
        client.connectBlocking();
        Thread.sleep(3000);
        System.out.println(client.results);
        client.closeBlocking();

        List<JSONObject> lol = new ArrayList<>();
        for(String element : client.results){
            lol.add(new JSONObject(element));
        }

        for(JSONObject element : lol){
            assertEquals(element.toMap().get("type"),"ob");
            System.out.println("Type ob is correct.");
        }
    }

    @Test(dataProvider = "candle_pairs",dependsOnMethods = {"checkPairs"})
    public void checkCandlesTypes(String pairs) throws URISyntaxException, InterruptedException {
        System.out.println("Checking: "+pairs);
        ExampleClient  client = new ExampleClient(new URI( ws ), pairs);
        client.connectBlocking();
        Thread.sleep(3000);
        System.out.println(client.results);
        client.closeBlocking();

        List<JSONObject> lol = new ArrayList<>();
        for(String element : client.results){
            lol.add(new JSONObject(element));
        }

        for(JSONObject element : lol){
            assertEquals(element.toMap().get("type"),"candle_m1");
            System.out.println("Type candle_m1 is correct.");
        }
    }


    @DataProvider(name = "ob_pairs")
    public static Object[][] ob_pairs() {
        return new Object[][] {
                { backendRequests.BTC_USD_ob_pair},
                { backendRequests.BTC_ETH_ob_pair},
                { backendRequests.BTC_EUR_ob_pair},
                { backendRequests.ETH_EUR_ob_pair},
                { backendRequests.ETH_USD_ob_pair}
        };
    }


    @DataProvider(name = "candle_pairs")
    public static Object[][] candle_pairs() {
        return new Object[][] {
                { backendRequests.BTC_USD_candle_m1_pair},
                { backendRequests.BTC_ETH_candle_m1_pair},
                { backendRequests.BTC_EUR_candle_m1_pair},
                { backendRequests.ETH_EUR_candle_m1_pair},
                { backendRequests.ETH_USD_candle_m1_pair}
        };
    }





}
