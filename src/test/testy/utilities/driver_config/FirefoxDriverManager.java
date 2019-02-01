package testy.utilities.driver_config;

import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverManager extends DriverManager {


    @Override
    public void setupDefaultDriver(){
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
}

