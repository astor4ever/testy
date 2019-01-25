package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {


    private final WebDriver driver;
    private final WebDriverWait wait;


    public MainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }



    public String getOrderbookText(){
        return driver.findElement(By.xpath("//span[text()='Orderbook']")).getText();
    }


}
