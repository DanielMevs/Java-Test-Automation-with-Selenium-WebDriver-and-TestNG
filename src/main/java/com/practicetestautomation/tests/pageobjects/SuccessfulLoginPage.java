package com.practicetestautomation.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulLoginPage extends BasePage {
    private final By logoutButtonLocator = By.linkText("Log out");

    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(logoutButtonLocator);
    }

    public void load() {
        waitForElement(logoutButtonLocator);
    }
}
