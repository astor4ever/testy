package com.testautomationguru.container.test;

import com.testautomationguru.container.test.utilities.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class SetUpUI {

    private WebDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {

        File f = new File("."); // current directory

        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String localRun = PropertyManager.getInstance().getLocalRun();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        if(localRun.equals("true")){
            PropertyManager.getInstance().setChromeWebDriver();
            driver = new ChromeDriver();
        }else {
            if (System.getProperty("browser").equals("firefox")) {
                dc = DesiredCapabilities.firefox();
            }
            String host = System.getProperty("seleniumHubHost");
            driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
        }
        driver.get("http://dv.investimetric.io:81/");
        System.out.println("Browser launched and navigated to Investimetric");
    }


    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }




}
