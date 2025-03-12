package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final String logoutButtonText = "Logout";
    By addCart = By.id("add-to-cart-sauce-labs-backpack");
    By removeButton = By.id("remove-sauce-labs-backpack");
    By shoppingCartButton = By.cssSelector("[id=\"shopping_cart_container\"]>a");
    By checkoutButton = By.cssSelector("[data-test=\"checkout\"]");
    By firstNameCheckout = By.id("first-name");
    By lastNameCheckout = By.id("last-name");
    By postalCodeCheckout = By.id("postal-code");
    By continueCheckout = By.id("continue");
    By finishCheckout = By.id("finish");
    By orderConfirmationMessage = By.cssSelector("[data-test=\"complete-header\"]");
    By errorMessageContainer = By.cssSelector("[class=\"error-message-container error\"]>h3");
    By cartItem = By.cssSelector("[class=\"cart_item\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addCart).click();
    }

    public String verifyItemIsAdded() {
        return driver.findElement(removeButton).getText();
    }

    public void clickCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    public Boolean verifyCartPageItem() {
        return driver.findElement(cartItem).isDisplayed();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void addValueToFirstNameOnCheckoutScreen(String firstName) {
        driver.findElement(firstNameCheckout).sendKeys(firstName);
    }

    public void addValueToLastNameOnCheckoutScreen(String secondName) {
        driver.findElement(lastNameCheckout).sendKeys(secondName);
    }

    public void addValueToPostalCodeOnCheckoutScreen(String postalCode) {
        driver.findElement(postalCodeCheckout).sendKeys(postalCode);
    }

    public void clickContinueButtonOnCheckoutScreen() {
        driver.findElement(continueCheckout).click();
    }

    public void clickFinishButtonOnCheckoutScreen() {
        driver.findElement(finishCheckout).click();
    }

    public String getOrderConfirmationMessage() {
        return driver.findElement(orderConfirmationMessage).getText();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }
}
