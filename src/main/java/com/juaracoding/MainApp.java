package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;


public class MainApp {
    static WebDriver driver;


    public static void main(String[] args) {
        // Open Browers
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/");

        // Login
        LoginPage loginPage = new LoginPage();
        loginPage.Login();
        System.out.print("Status Test login: ");
        DriverSingleton.contains(loginPage.loginText(), "Hello");

        // Add to Cart
        CartPage cartPage = new CartPage();
        cartPage.cart();
        System.out.print("Status Test Add To Cart: ");
        DriverSingleton.contains(cartPage.cartText(), "has been added to your cart.");

        // Checkout
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout();
        System.out.print("Status Checkout: ");
        checkoutPage.checkbox(false);
        DriverSingleton.contains(checkoutPage.errorTxt(), "Your order has been received.");
        DriverSingleton.delay(3);
        System.out.print("Status Checkout: ");
        checkoutPage.checkbox(true);
        DriverSingleton.contains(checkoutPage.accOrderTxt(), "Your order has been received.");

        // Close Browers
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}
