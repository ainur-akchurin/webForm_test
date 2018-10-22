package ru.ak.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ak.app.resourses.Resourse;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ResendPage {
    private final WebDriver driver;
    private final WebDriverWait wait ;

    public ResendPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void closeFrame() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Resourse.GOOGLE_DIALOG)));
        driver.switchTo().frame(1);

        if(new Random().nextInt(1)==0)
            driver.findElement(By.xpath(Resourse.BTN_NO_IN_GOOGLE_FRAME)).click();
        else
            driver.findElement(By.xpath(Resourse.BTN_YES_IN_GOOGLE_FRAME)).click();

        driver.switchTo().defaultContent();
    }

    public void generateRandomAnswers() {
        List<WebElement> buttons = driver.findElements(By.className(Resourse.SWITCH_BUTTON));
        Random randomInt = new Random();

        buttons.get(randomInt.nextInt(2)).click();          // switch interests (0,1)

        buttons.get(randomInt.nextInt(5) + 2).click();      // switch members   (2-6)

        int btnNumber = 7 + randomInt.nextInt(3);           // switch answers about follow a process for managing work question (7-9)
        if (btnNumber == 9) {
            buttons.get(btnNumber).click();
            driver.findElement(By.xpath(Resourse.FIELD_OTHER)).sendKeys(Resourse.randomText(10));
        } else
            buttons.get(btnNumber).click();
    }

    public boolean submit() {
        WebElement submitBtn = driver.findElement(By.xpath(Resourse.BTN_SUBMIT_ANSWERS));
        if (!submitBtn.isEnabled()) {
            return false;
        } else {
            submitBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(submitBtn));
            WebElement successSurvey = driver.findElement(By.xpath(Resourse.SURVEY_SUCCESS));
            return successSurvey.isDisplayed();
        }
    }

    public boolean clickResendEmail() {
        WebElement resendBtn = driver.findElement(By.xpath(Resourse.BTN_RESEND_EMAIL));
        resendBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(resendBtn));
        return !resendBtn.isDisplayed();
    }

    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(Resourse.SCRIPT_SCROLL);
    }

    public String getTwitterUrl() {
        WebElement twitterBtn = driver.findElements(By.className(Resourse.WG_FOOTER_SOCIAL_LIST)).get(0);
        return twitterBtn.findElement(By.xpath(Resourse.BTN_TWITTER_PATH)).getAttribute(Resourse.ATTRIBUTE_HREF);
    }

    public String getTwitterIconUrl() {
        WebElement twitterBtn = driver.findElements(By.className(Resourse.WG_FOOTER_SOCIAL_LIST)).get(0);
        return twitterBtn.findElement(By.tagName(Resourse.TAG_USE)).getAttribute(Resourse.ATTRIBUTE_XLINK_HREF);
    }
}
