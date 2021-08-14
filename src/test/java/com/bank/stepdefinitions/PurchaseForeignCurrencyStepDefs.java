package com.bank.stepdefinitions;

import com.bank.pages.PayBillsPage;
import com.bank.utilities.BrowserUtils;
import com.bank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {
    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currenciesList) {

        Select currencyDropdown = new Select(payBillsPage.currencyDropdown);
        List<String> actualList = BrowserUtils.getElementsText(currencyDropdown.getOptions());
        actualList.remove(0);
        Assert.assertEquals(currenciesList, actualList);

    }

    @When("User tries to calculate cost")
    public void user_tries_to_calculate_cost() {
        payBillsPage.calculateCostsButton.click();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertNotNull(alert);
    }

    @Given("User selects {string} as currency")
    public void user_selects_as_currency(String currencyType) {
        Select currenciesDropdowm = new Select(payBillsPage.currencyDropdown);
        currenciesDropdowm.selectByVisibleText(currencyType);
    }

}
