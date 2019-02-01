package testy.utilities.driver_config;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerFactory {


    public static DriverManager getManager(DriverType type){


        DriverManager driverManager;

        switch (type) {
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case REMOTE:
                driverManager = new RemoteDriverManager();
                break;
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }


}
