package com.company.automation.tests;

import com.company.automation.base.BaseTest;
import com.company.automation.pages.HomePage;
import com.company.automation.pages.ProductPage;
import com.company.automation.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest extends BaseTest {

    @Test
    public void searchAndOpenFirstProduct() {
        HomePage home = new HomePage(driver);
        home.open();

        SearchResultsPage results = home.search("laptop");
        String firstTitle = results.getFirstProductTitle();
        Assert.assertTrue(firstTitle.toLowerCase().contains("laptop"), "First product title should contain 'laptop'");

        ProductPage product = results.openFirstProduct();
        String productTitle = product.getProductTitle();
        String productPrice = product.getProductPrice();

        System.out.println("Product Title: " + productTitle);
        System.out.println("Product Price: " + productPrice);

        Assert.assertFalse(productTitle.isEmpty(), "Product title should not be empty");
        Assert.assertFalse(productPrice.isEmpty(), "Product price should not be empty");
    }
}
