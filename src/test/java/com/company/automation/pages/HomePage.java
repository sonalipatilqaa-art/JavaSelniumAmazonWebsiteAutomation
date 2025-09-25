package com.company.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private String baseUrl = "https://www.amazon.co.uk/";
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By acceptCookies = By.id("sp-cc-accept"); // cookies popup

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(baseUrl);
        handleCookies();
    }

    private void handleCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
            cookiesButton.click();
        } catch (Exception ignored) {}
    }

    public SearchResultsPage search(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        box.clear();
        box.sendKeys(query);

        WebElement button = driver.findElement(searchButton);
        button.click();

        return new SearchResultsPage(driver);
    }
}
