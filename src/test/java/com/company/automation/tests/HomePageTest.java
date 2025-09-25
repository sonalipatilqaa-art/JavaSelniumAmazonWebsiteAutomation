package com.company.automation.tests;

import com.company.automation.base.BaseTest;
import com.company.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {
        HomePage home = new HomePage(driver);
        home.open();
        Assert.assertTrue(driver.getTitle().contains("Amazon"), "Amazon UK homepage should load");
    }
}
