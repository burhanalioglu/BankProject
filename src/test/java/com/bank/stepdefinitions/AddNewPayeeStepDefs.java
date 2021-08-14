package com.bank.stepdefinitions;

import com.bank.pages.PayBillsPage;
import com.bank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("User creates new payee using following information")
    public void user_creates_new_payee_using_following_information(Map<String, String> newPayeeInfo) {
        payBillsPage.payeeName.sendKeys(newPayeeInfo.get("Payee Name"));
        payBillsPage.payeeAdress.sendKeys(newPayeeInfo.get("Payee Address"));
        payBillsPage.payeeAccount.sendKeys(newPayeeInfo.get("Account"));
        payBillsPage.payeeDetails.sendKeys(newPayeeInfo.get("Payee details"));
        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        Assert.assertEquals(message, payBillsPage.newPayeeAlert.getText());
    }
}
