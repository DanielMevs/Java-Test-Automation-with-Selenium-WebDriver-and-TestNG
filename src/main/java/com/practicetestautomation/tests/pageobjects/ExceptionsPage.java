package com.practicetestautomation.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionsPage extends BasePage {
    private final By addButtonLocator = By.id("add_btn");
    private final By editButtonLocator = By.id("edit_btn");
    private final By row1InputField = By.xpath("//div[@id='row1']/input");
    private final By row2InputField = By.xpath("//div[@id='row2']/input");
    private final By save1ButtonLocator = By.xpath(
            "//div[@id='row1']/button[@name='Save']");
    private final By save2ButtonLocator = By.xpath(
            "//div[@id='row2']/button[@name='Save']");
    private final By successMessage = By.id("confirmation");
    private final By instructionsLocator = By.id("instructions");

    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAddButton() {
        driver.findElement(addButtonLocator).click();
    }

    public void clickEditButton() {
        driver.findElement(editButtonLocator).click();
    }

    public boolean isRowTwoDisplayedAfterWait() {
        return waitForIsDisplayed(row2InputField);
    }

    public void enterFoodInRow1(String foodName) {
        WebElement row1Input = driver.findElement(row1InputField);
        row1Input.clear();
        row1Input.sendKeys(foodName);
    }

    public void enterFoodInRow2(String foodName) {
        driver.findElement(row2InputField).sendKeys(foodName);
    }

    public void saveRow1() {
        driver.findElement(save1ButtonLocator).click();
    }

    public void saveRow2() {
        driver.findElement(save2ButtonLocator).click();
    }

    public String getSuccessMessage() {
        return waitForElement(successMessage).getText();
    }

    public boolean isInstructionsElementHiddenAfterWait(){
        return waitForIsHidden(instructionsLocator);
    }
}
