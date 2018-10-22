package ru.ak;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ak.steps.Steps;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testScenario(){
        Steps step = new Steps(driver);
        step.openUrl();
        step.clickGetStarted();
        step.fillEmailField();
        step.clickCreateAccount();
        step.checkMovedNextPage();
        step.fillQASection();
        step.clickResendEmail();
        step.checkFollowAsSection();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
