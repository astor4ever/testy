package testy.utilities;
import java.io.*;
import java.util.*;
import java.text.*;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.*;

import org.testng.*;
public class ScreenshotListener extends TestListenerAdapter {


    private WebDriver driver;


    @Override
    public void onTestFailure (ITestResult result) {
            ITestContext context = result.getTestContext();
            this.driver = (WebDriver) context.getAttribute("driver");
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String methodName = result.getName();
            if (!result.isSuccess()) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
                    File destFile = new File(reportDirectory + "/test-output/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
                    FileUtils.copyFile(scrFile, destFile);
                    System.out.println(System.getProperty("jenkinsBuild")+ "prop");
                    Reporter.log("<a href='" + "/job/testy/"+System.getProperty("jenkinsBuild")+"/artifact/front/"+destFile.getAbsolutePath().substring(34) + "'> <img src='" + "/job/testy/"+System.getProperty("jenkinsBuild")+"/artifact/front/"+destFile.getAbsolutePath().substring(34) + "' height='100' width='100'/> </a>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }



}