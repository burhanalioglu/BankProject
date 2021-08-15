package com.bank.stepdefinitions;

import com.bank.pages.PayBillsPage;
import com.bank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class PayBillsStepDefs {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("User selects {string} as Payee")
    public void user_selects_as_Payee(String payeeType) {
        BrowserUtils.waitFor(1);
        Select select = new Select(payBillsPage.payeeDropdown);
        select.selectByVisibleText(payeeType);

    }

    @When("User selects type {string} as Account Type")
    public void user_selects_type_as_Account_Type(String accountType) {
        Select select = new Select(payBillsPage.accountDropdown);
        select.selectByVisibleText(accountType);
    }

    @When("User enters {string} as Amount")
    public void user_enters_as_Amount(String amount) {
        payBillsPage.amount.sendKeys(amount);
    }

    @When("User enters {string} as Date")
    public void user_enters_as_Date(String date) {
        payBillsPage.date.sendKeys(date);
    }

    @When("User enters {string} as Description")
    public void user_enters_as_Description(String description) {
        payBillsPage.description.sendKeys(description);
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String string) {
        payBillsPage.payButton.click();
    }

    @Then("The payment was successfully submitted. message should be displayed")
    public void the_payment_was_successfully_submitted_message_should_be_displayed() {
        String expectedMessage = "The payment was successfully submitted.";
        String actualMessage = payBillsPage.paymentSubmissionMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("Please fill out this field. message should be displayed on {string}")
    public void please_fill_out_this_field_message_message_should_be_displayed_on(String element) {
        String expectedMessage = "Please fill out this field.";
        String actualMessage = "";
        if (element.equals("date")) {
            actualMessage = payBillsPage.date.getAttribute("validationMessage");
        } else if (element.equals("amount")) {
            actualMessage = payBillsPage.amount.getAttribute("validationMessage");
        }
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
