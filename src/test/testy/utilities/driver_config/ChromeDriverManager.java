package testy.utilities.driver_config;

import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverManager extends DriverManager {


    @Override
    public void setupDefaultDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
}

