package com.bank.stepdefinitions;

import com.bank.pages.AccountActivityPage;
import com.bank.utilities.BrowserUtils;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("User navigates to {string}")
    public void user_navigates_to(String module) {
        accountActivityPage.navigateTo(module);
    }

    @When("User enters date range from {string} to {string}")
    public void user_enters_date_range_from_to(String fromDate, String toDate) {
        accountActivityPage.fromDate.clear();
        accountActivityPage.toDate.clear();
        accountActivityPage.fromDate.sendKeys(fromDate);
        accountActivityPage.toDate.sendKeys(toDate);
    }

    @When("Click search of transaction")
    public void click_search_of_transaction() {
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Print Dates")
    public void printDates() {
        accountActivityPage.getListOfDateResults();
    }

    @Then("Results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromDate = simpleDateFormat.parse(from);
            Date toDate = simpleDateFormat.parse(to);
            List<Date> actualDateList = accountActivityPage.getListOfDateResults();

            for (Date date : actualDateList) {
                Assert.assertTrue("verify that actual date is before toDate", date.before(toDate) || date.equals(toDate));
                Assert.assertTrue("verify that actual date is after fromDate", date.after(fromDate) || date.equals(fromDate));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Then("Results should be sorted by most recent date")
    public void results_should_be_sorted_by_most_recent_date() {
        List<Date> actualDateList = accountActivityPage.getListOfDateResults();
        for (int i = 0; i < actualDateList.size() - 1; i++) {
            Assert.assertTrue(actualDateList.get(i).after(actualDateList.get(i + 1)));
        }
    }

    @Then("Results table should only not contain transactions dated {string}")
    public void results_table_should_only_not_contain_transactions_dated(String exceptedDate) throws ParseException {
        List<Date> actualDateList = accountActivityPage.getListOfDateResults();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(exceptedDate);
        Assert.assertFalse(actualDateList.contains(date));
    }


    @When("User enters description {string}")
    public void user_enters_description(String description) {
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(description);
    }

    @Then("Results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {

        List<String> descTextsList = BrowserUtils.getElementsText(accountActivityPage.descriptionResults);
        for (String eachText : descTextsList) {
            Assert.assertTrue(eachText.contains(description));
        }

    }

    @But("Results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String description) {

        List<String> descTextsList = BrowserUtils.getElementsText(accountActivityPage.descriptionResults);
        for (String eachText : descTextsList) {
            Assert.assertFalse(eachText.contains(description));
        }
    }

    @Then("Results table should show at least one result under {string}")
    public void results_able_should_show_at_least_one_result_under(String depositOrWithdrawal) {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> moneyActivityList = accountActivityPage.getMoneyActivitiyList(depositOrWithdrawal);
        Assert.assertTrue(moneyActivityList.size() > 0);

    }

    @When("User selects type {string}")
    public void user_selects_type(String type) {
        Select typeDropdown = new Select(accountActivityPage.typeDropdown);
        typeDropdown.selectByVisibleText(type);
        accountActivityPage.findButton.click();
    }

    @But("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String depositOrWithdrawal) {
        List<String> moneyActivityList = accountActivityPage.getMoneyActivitiyList(depositOrWithdrawal);
        Assert.assertEquals(0, moneyActivityList.size());
    }

}
