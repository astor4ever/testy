package testy.utilities.driver_config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class RemoteDriverManager extends DriverManager {


    @Override
    public void setupDefaultDriver(){
        String host = System.getProperty("seleniumHubHost");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability("takesScreenshot", true);
        try {
            driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}