package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    WebDriver driver;

    By pageTitle = By.className("title");
    By sortDropdown = By.className("product_sort_container");
    By productPrices = By.className("inventory_item_price");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void sortByPriceLowToHigh() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText("Price (low to high)");
    }

    public java.util.List<org.openqa.selenium.WebElement> getAllPrices() {
        return driver.findElements(productPrices);
    }
}