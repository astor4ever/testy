package com.testautomationguru.container.test;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.testng.Assert.assertTrue;


public class backend {




    @Test
public void test1(){
    assertTrue(true);
}


    @BeforeTest
    public void test() throws URISyntaxException {

        String[] arguments = new String[] {"123"};
            ExampleClient.main(arguments);







    }




}
