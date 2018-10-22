package ru.ak.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ak.app.resourses.Resourse;

import java.util.concurrent.TimeUnit;

public class HomePage  {
    private final WebDriver driver;
    private final WebDriverWait wait ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    public void openUrl() {
        driver.get(Resourse.HOME_PAGE_URL);
    }

    public ResendPage clickCreateAccount() {
        driver.findElement(By.xpath(Resourse.BTN_CREATE_ACCOUNT)).click();
        wait.until(ExpectedConditions.urlToBe(Resourse.RESEND_PAGE_URL));
        return new ResendPage(driver);
    }

    public void fillEmailField() {
        driver.findElement(By.xpath(Resourse.FIELD_EMAIL)).sendKeys(Resourse.randomText(5)+ Resourse.EMAIL_MASK);
    }

    public void clickGetStartedForFree() {
        driver.findElement(By.xpath(Resourse.BTN_GET_STARTED_FOR_FREE)).click();
    }
}
