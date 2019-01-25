package testy;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;


public class UITests extends SetUpUI{

    MainPage mp;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();

    }

    @Test
    public void checkTitle() throws InterruptedException {
        mp = PageFactory.initElements(driver,MainPage.class);
        Thread.sleep(1500);
        assertEquals(mp.getOrderbookText(),"Orderbook");
    }

}
