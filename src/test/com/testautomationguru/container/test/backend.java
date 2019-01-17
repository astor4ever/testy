package com.testautomationguru.container.test;


import com.testautomationguru.container.test.resources.backendRequests;
import org.testng.annotations.Test;
import java.net.URI;
import java.net.URISyntaxException;
import static org.testng.Assert.*;


public class backend {

    String ws = "s://dv.investimetric.io:5000/ws";


    @Test
    public void test() throws URISyntaxException, InterruptedException {
        ExampleClient  client = new ExampleClient(new URI( ws ), backendRequests.pingPong_request);
        client.connectBlocking();
        Thread.sleep(5000);
        System.out.println(client.results);
        client.closeBlocking();

        assertTrue(client.results.contains("{\"type\":\"pong\"}\t"));









    }







}
