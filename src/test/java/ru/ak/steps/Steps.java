package ru.ak.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ru.ak.app.resourses.Resourse;
import ru.ak.app.pages.HomePage;
import ru.ak.app.pages.ResendPage;


public class Steps {
    private HomePage homePage;
    private ResendPage resendPage;
    private WebDriver driver;

    public Steps(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.driver = driver;
    }

    @Step("Open url: wrike.com")
    public void openUrl() {
        homePage.openUrl();
    }

    @Step("Click \"Get started for free\" button near \"Login\" button")
    public void clickGetStarted() {
        homePage.clickGetStartedForFree();
    }

    @Step("Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”)")
    public void fillEmailField() {
        homePage.fillEmailField();
    }

    @Step("Click on \"Create my Wrike account\" button")
    public void clickCreateAccount() {
        resendPage = homePage.clickCreateAccount();
    }

    @Step("Check with assertion that you are moved to the next page")
    public void checkMovedNextPage() {
        Assert.assertEquals(Resourse.RESEND_PAGE_URL,resendPage.getCurrentUrl());
    }

    @Step("Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted")
    public void fillQASection() {
        resendPage.closeFrame();
        resendPage.generateRandomAnswers();
        Assert.assertTrue(resendPage.submit());
    }

    @Step("Click on \"Resend email\" + check it with assertion")
    public void clickResendEmail() {
        Assert.assertTrue(resendPage.clickResendEmail());
    }

    @Step("Check that section \"Follow us\" at the site footer contains the \"Twitter\" button that leads to the correct url and has the correct icon.")
    public void checkFollowAsSection() {
        resendPage.scroll();
        Assert.assertEquals(Resourse.TWITTER_URL, resendPage.getTwitterUrl());
        Assert.assertEquals(Resourse.TWITTER_ICON_URL, resendPage.getTwitterIconUrl());
    }
}
