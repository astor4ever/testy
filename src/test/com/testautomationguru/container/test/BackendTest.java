package com.testautomationguru.container.test;


import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.testautomationguru.container.test.resources.*;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class BackendTest {

    private String ws = "s://dv.investimetric.io:5000/ws";
    Gson gson = new Gson();


    @Test
    public void checkConnection() throws InterruptedException, URISyntaxException {
        ExampleClient client = new ExampleClient(new URI( ws ), backendRequests.pingPong);
        client.connectBlocking();
        Thread.sleep(3000);
        System.out.println(client.results);
        client.closeBlocking();
        assertTrue(client.results.contains("{\"type\":\"pong\"}\t"));
    }

    @Test
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
        assertEquals(pairsResults,backendPatternRespons.pairsListPattern());
    }

    @Test(dataProvider = "pairs")
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

    @DataProvider(name = "pairs")
    public static Object[][] credentials() {
        return new Object[][] {
                { backendRequests.BTC_USD_pair },
                { backendRequests.BTC_ETH_pair },
                { backendRequests.BTC_EUR_pair },
                { backendRequests.ETH_EUR_pair },
                { backendRequests.ETH_USD_pair }
        };
    }




}
