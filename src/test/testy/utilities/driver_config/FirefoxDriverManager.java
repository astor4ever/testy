package testy.utilities.driver_config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverManager extends DriverManager {


    @Override
    public void setupDefaultDriver(){
        System.setProperty("webdriver.gecko.driver", "drivers/.exe");
        driver = new FirefoxDriver();
    }
}

