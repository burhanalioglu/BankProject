package com.bank.stepdefinitions;

import com.bank.pages.AccountActivityPage;
import com.bank.pages.AccountSummaryPage;
import com.bank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {
    @When("User clicks on {string} link on the Account Summary page")
    public void user_clicks_on_link_on_the_Account_Summary_page(String accountName) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.getAccount(accountName).click();
    }


    @Then("Account dropdown should have {string} selected")
    public void account_dropdown_should_have_selected(String selectedOption) {
        Select select = new Select(new AccountActivityPage().accountDropdown);
        Assert.assertEquals(selectedOption, select.getFirstSelectedOption().getText());
    }


}
