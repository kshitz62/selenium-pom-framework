package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");

        // Using Page Object Model - clean, readable test logic
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        System.out.println("Page Title: " + inventoryPage.getPageTitle());

        inventoryPage.sortByPriceLowToHigh();
        List<WebElement> prices = inventoryPage.getAllPrices();
        System.out.println("Lowest price: " + prices.get(0).getText());
        System.out.println("Highest price: " + prices.get(prices.size()-1).getText());

        driver.quit();
    }
}