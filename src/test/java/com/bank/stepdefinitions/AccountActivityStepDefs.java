package com.bank.stepdefinitions;

import com.bank.pages.AccountActivityPage;
import com.bank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDefs {

    @Then("Account dropdown should have following options")
    public void account_dropdown_should_have_following_options(List<String> expectedList) {
        Select select = new Select(new AccountActivityPage().accountDropdown);
        List<WebElement> actualElementList = select.getOptions();
        List<String> actualList = new ArrayList<>();
        for (WebElement eachElement : actualElementList) {
            actualList.add(eachElement.getText());
        }
        Assert.assertEquals(expectedList, actualList);
    }

    @Then("User sees following columns in Transactions table")
    public void user_sees_following_columns_in_Transactions_table(List<String> expectedList) {
        List<WebElement> actualElementList = new AccountActivityPage().allTransactionsTableHeaderList;
        List<String> actualList = new ArrayList<>();
        for (WebElement eachElement : actualElementList) {
            actualList.add(eachElement.getText());
        }
        Assert.assertEquals(expectedList, actualList);
    }
}
