package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.HomePage;
import page.LoginPage;
import utils.BaseClass;

public class AddToCartSteps extends BaseClass {
    final String removeButtonTextToBeMatched = "Remove";
    LoginPage login;
    HomePage home;

    @Given("User is logged In")
    public void user_is_logged_in() {
        login = launchApplication();
        login.enterUserName();
        login.enterPassword();
        home = login.clickLoginButton();
    }

    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        home.clickAddToCart();
    }

    @And("product is added to the cart successfully")
    public void product_is_added_to_the_cart_successfully() {
        String removeButtonText = home.verifyItemIsAdded();
        Assert.assertEquals(removeButtonText, removeButtonTextToBeMatched);
    }

    @Then("User clicks on Cart")
    public void user_clicks_on_cart() {
        home.clickCartButton();
    }

    @Then("Item should be shown in the cart")
    public void item_should_be_shown_in_the_cart() {
        Assert.assertTrue(home.verifyCartPageItem());
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        home.clickCheckoutButton();
    }

    @And("User fills out the checkout form with first name {string}, last name {string}, and postal code {string}")
    public void user_fills_out_the_checkout_form(String firstName, String lastName, String postalCode) {
        home.addValueToFirstNameOnCheckoutScreen(firstName);
        home.addValueToLastNameOnCheckoutScreen(lastName);
        home.addValueToPostalCodeOnCheckoutScreen(postalCode);
    }

    @And("User clicks continue on the checkout screen")
    public void user_clicks_continue_on_the_checkout_screen() {
        home.clickContinueButtonOnCheckoutScreen();
    }

    @And("User completes the order")
    public void user_completes_the_order() {
        home.clickFinishButtonOnCheckoutScreen();
    }

    @Then("Order confirmation should be displayed")
    public void order_confirmation_should_be_displayed() {
        String confirmationMessage = home.getOrderConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!");
    }

    @When("User attempts to checkout without filling out the form")
    public void user_attempts_to_checkout_without_filling_out_the_form() {
        home.clickCheckoutButton();
        home.clickContinueButtonOnCheckoutScreen();
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(home.isErrorMessageDisplayed());
    }

    @After
    public void afterScenario() {
        tearDown();
    }
}
