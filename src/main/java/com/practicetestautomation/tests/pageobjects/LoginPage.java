package com.practicetestautomation.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By usernameInputLocator = By.id("username");
    private final By passwordInputLocator = By.id("password");
    private final By submitButtonLocator = By.id("submit");
    private final By errorMessageLocator = By.id("error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public SuccessfulLoginPage executeLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
        return new SuccessfulLoginPage(driver);
    }

    public String getErrorMessage() {
        WebElement errorMessageElement = waitForElement(errorMessageLocator);
        return errorMessageElement.getText();
    }
}
