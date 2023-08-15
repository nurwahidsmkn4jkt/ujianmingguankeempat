package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
    WebElement dismiss;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath =  "//input[@id='password']")
    WebElement password;


    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;

    @FindBy(className = "woocommerce-MyAccount-content")
    WebElement getLogin;

    public void Login(){
        dismiss.click();
        myAccount.click();
        username.sendKeys("Nurwahid");
        password.sendKeys("Nurwahid11");
        btnLogin.click();
    }
    public String loginText(){
        return getLogin.getText();
    }

}
