package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "custom-logo")
    WebElement dashboard;

    @FindBy(linkText = "PINK DROP SHOULDER OVERSIZED T SHIRT")
    WebElement productOne;

    @FindBy(id = "pa_color")
    WebElement color;

    @FindBy(id = "pa_size")
    WebElement size;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addCart;

    @FindBy(className = "woocommerce-message")
    WebElement getAdd;

    @FindBy(linkText = "Products")
    WebElement homeProduct;

    @FindBy(linkText = "BLACK LUX GRAPHIC T-SHIRT")
    WebElement productTwo;

    public void cart(){
        dashboard.click();
        productOne.click();
        select();

        homeProduct.click();
        productTwo.click();
        select();
    }
    public void select(){
        Select selectColor = new Select(color);
        selectColor.selectByIndex(1);
        Select selectSize = new Select(size);
        selectSize.selectByIndex(2);
        addCart.click();
    }
    public String cartText(){
        return getAdd.getText();
    }
}
