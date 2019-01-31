package testy.utilities.driver_config;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void setupDefaultDriver();

    public void quitDriver(){
        if(null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if(null == driver) {
            setupDefaultDriver();
        }
        return driver;
    }

}
