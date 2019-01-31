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
                    String reportDirectory;
                    if (System.getProperty("localRun") != null) {
                        reportDirectory = "/home/dev/workspace/testy/front/target/surefire-reports";
                    } else {
                        reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                    }
                    System.out.println("REPORT DIRECTORY IS:" + reportDirectory);
                    File destFile = new File(reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
                    System.out.println("DEST FILE" + destFile);
                    FileUtils.copyFile(scrFile, destFile);
                    Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                System.out.println("SCREEN SAVED");
            }
        System.out.println("SCREEN SAVED2");
    }



}