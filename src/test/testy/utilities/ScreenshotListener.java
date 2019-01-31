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
                    File destFile = new File(reportDirectory + "/test-output/failed_screens/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
                    FileUtils.copyFile(scrFile, destFile);
                    Reporter.log("<a href='" + destFile.getAbsolutePath().substring(33) + "'> <img src='" + destFile.getAbsolutePath().substring(33) + "' height='100' width='100'/> </a>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }



}