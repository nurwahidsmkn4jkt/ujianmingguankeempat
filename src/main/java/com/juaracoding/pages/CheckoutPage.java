package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "icon_bag_alt")
    WebElement icnCo;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    WebElement coBtn;

    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id = "billing_last_name")
    WebElement lastName;

    @FindBy(id = "billing_company")
    WebElement company;

    @FindBy(id = "select2-billing_country-container")
    WebElement country;

    @FindBy(xpath = "//input[@role='combobox']")
    WebElement searchCountry;

    @FindBy(id = "billing_address_1")
    WebElement address;

    @FindBy(id = "billing_city")
    WebElement city;

    @FindBy(id = "select2-billing_state-container")
    WebElement state;

    @FindBy(xpath = "//input[@role='combobox']")
    WebElement searchState;

    @FindBy(id = "billing_postcode")
    WebElement postCode;

    @FindBy(id = "billing_phone")
    WebElement phone;

    @FindBy(className = "woocommerce-terms-and-conditions-checkbox-text")
    WebElement terms;

    @FindBy(xpath = "//*[@id=\"place_order\"]")
    WebElement orderBtn;

    @FindBy(className = "woocommerce-error")
    WebElement errMessage;

    @FindBy(className = "woocommerce-thankyou-order-received")
    WebElement accOrder;


    public void checkout(){
        icnCo.click();
        coBtn.click();
        clear();
        checkoutForms();
        DriverSingleton.delay(3);
    }
    public void clear(){
        firstName.clear();
        lastName.clear();
        company.clear();
        address.clear();
        city.clear();
        postCode.clear();
        phone.clear();
    }
    public void checkoutForms(){
        firstName.sendKeys("Nur");
        lastName.sendKeys("Wahid");
        company.sendKeys("JuaraCoding");
        country.click();
        searchCountry.sendKeys("Indonesia" + Keys.ENTER);
        address.sendKeys("Jl. Menuju masa depan");
        city.sendKeys("Jakarta Timur");
        state.click();
        searchState.sendKeys("DKI Jakarta" + Keys.ENTER);
        postCode.sendKeys("13910");
        phone.sendKeys("083129587862");
    }

    public void checkbox(boolean checkbox){
        if (checkbox){
            DriverSingleton.delay(3);
            DriverSingleton.scroll();
            terms.click();
            orderBtn.click();
        }
        else {
            orderBtn.click();
        }
    }

    public String accOrderTxt(){

        return accOrder.getText();
    }

    public String errorTxt(){

        return errMessage.getText();
    }
}
