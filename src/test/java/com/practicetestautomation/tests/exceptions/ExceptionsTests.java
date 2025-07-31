package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.tests.BaseTest;
import com.practicetestautomation.tests.pageobjects.ExceptionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExceptionsTests extends BaseTest {
    @Test
    public void noSuchElementExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(),
                "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(),
                "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        exceptionsPage.isRowTwoDisplayedAfterWait();
        exceptionsPage.enterFoodInRow2("Sushi");
        exceptionsPage.saveRow2();
        String actualMessage = exceptionsPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, "Row 2 was saved",
                "Message is not expected");
    }

    @Test
    public void invalidElementStateExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickEditButton();
        exceptionsPage.enterFoodInRow1("Sushi");
        exceptionsPage.saveRow1();
        String actualMessage = exceptionsPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, "Row 1 was saved",
                "Message is not expected");
    }

    @Test
    public void staleElementExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isInstructionsElementHiddenAfterWait(),
                "Instructions test is still displayed");
    }

}
