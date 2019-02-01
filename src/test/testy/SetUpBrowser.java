package testy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testy.utilities.PropertyManager;
import testy.utilities.driver_config.DriverManager;
import testy.utilities.driver_config.DriverManagerFactory;
import testy.utilities.driver_config.DriverType;

import java.net.MalformedURLException;
import java.net.URL;


public class SetUpBrowser {

    public WebDriver driver;


    @BeforeTest
    public void setUp(ITestContext context)  {

        DriverManager driverManager;
        if(System.getProperty("localRun") != null) {
            driverManager = DriverManagerFactory.getManager(DriverType.REMOTE);
        }else{
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        }


        driver = driverManager.getDriver();
        System.out.println("Browser launched.");
        context.setAttribute("driver", driver);
    }



    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }




}
