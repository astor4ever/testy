package testy.utilities.driver_config;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerFactory {


    public static DriverManager getManager(DriverType type){


        DriverManager driverManager;

        switch (type) {
            case FIREFOX:
                driverManager = new ChromeDriverManager();
                break;
            case REMOTE:
                driverManager = new RemoteDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }


}
