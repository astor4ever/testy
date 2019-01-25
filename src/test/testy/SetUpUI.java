package testy;

import testy.utilities.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class SetUpUI {

    public WebDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {


        DesiredCapabilities dc = DesiredCapabilities.chrome();
        PropertyManager.getInstance().setChromeWebDriver();
        driver = new ChromeDriver();
        if(System.getProperty("localRun") != null){
            if (System.getProperty("browser").equals("firefox")) {
                dc = DesiredCapabilities.firefox();
            }
            String host = System.getProperty("seleniumHubHost");
            driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
        System.out.println("Browser launched.");
        }

    }


    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }




}
