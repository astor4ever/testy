package testy.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//**********************************************************************************************************
//Author: Onur Baskirt
//Description: PropertyManager class reads global configurations and use them during test execution.
//**********************************************************************************************************
public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String local;
    private static String chromeWebDriver;
    private static String jenkinsBuild;
    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            //prop.load(new FileInputStream(propertyFilePath));
            String propertyFilePath = "selenium.properties";
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFilePath);



            //prop.load(this.getClass().getClassLoader().getResourceAsStream(propertyFilePath));
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        //Get properties from configuration.properties
        local = prop.getProperty("LocalRun");
        chromeWebDriver = prop.getProperty("chromeWebDriver");
        jenkinsBuild = prop.getProperty("BUILD_NUMBER");
    }

    public String getLocalRun () {
        return local;
    }

    public void setChromeWebDriver(){
        System.setProperty("webdriver.chrome.driver", chromeWebDriver);
    }

    public String getJenkinsBuild() { return  jenkinsBuild; }



}