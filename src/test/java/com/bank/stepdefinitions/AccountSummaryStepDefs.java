package com.bank.stepdefinitions;

import com.bank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    @Then("User sees following account types")
    public void user_sees_following_account_types(List<String> expectedList) {
        List<WebElement> actualElementList = new AccountSummaryPage().accountTypesList;
        List<String> actualList = new ArrayList<>();
        for (WebElement eachElement : actualElementList) {
            actualList.add(eachElement.getText());
        }
        Assert.assertEquals(expectedList, actualList);
    }

    @Then("User sees following columns in Credit Accounts table")
    public void user_sees_following_columns_in_Credit_Accounts_table(List<String> expectedList) {
        List<WebElement> actualElementList = new AccountSummaryPage().creditAccountsHeaderList;
        List<String> actualList = new ArrayList<>();
        for (WebElement eachElement : actualElementList) {
            actualList.add(eachElement.getText());
        }
        Assert.assertEquals(expectedList, actualList);
    }
}
