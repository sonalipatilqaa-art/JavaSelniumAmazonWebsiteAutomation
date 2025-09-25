package com.company.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private By resultsContainer = By.cssSelector("div.s-main-slot");
    private By productLinks = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result'] h2 a");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Find first clickable product reliably
    private WebElement getFirstVisibleProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait until the main container is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsContainer));

        // Retry loop for lazy-loaded products
        for (int i = 0; i < 5; i++) {
            List<WebElement> products = driver.findElements(productLinks);
            for (WebElement product : products) {
                if (product.isDisplayed() && product.getAttribute("href") != null) {
                    return product;
                }
            }

            // Scroll down a bit to load lazy elements
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }

        throw new RuntimeException("No visible products found in search results after scrolling.");
    }

    public String getFirstProductTitle() {
        return getFirstVisibleProduct().getText();
    }

    public ProductPage openFirstProduct() {
        WebElement firstProduct = getFirstVisibleProduct();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
        firstProduct.click();
        return new ProductPage(driver);
    }
}
