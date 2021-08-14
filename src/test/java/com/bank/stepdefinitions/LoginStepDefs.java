package com.bank.stepdefinitions;

import com.bank.pages.AccountSummaryPage;
import com.bank.pages.LoginPage;
import com.bank.pages.MainPage;
import com.bank.utilities.ConfigurationReader;
import com.bank.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sun.rmi.runtime.Log;

public class LoginStepDefs {

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        MainPage mainPage = new MainPage();
        mainPage.singInIcon.click();
    }

    @Given("User logged in")
    public void user_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new MainPage().singInIcon.click();
        new LoginPage().loginAsDriver();
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(username, password);
        new LoginPage().getRidOfSecurityError();
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String pageTitle) {
        Assert.assertTrue("Verify page title contains: \tExpected: " + pageTitle + "\tActual: " + Driver.get().getTitle(), Driver.get().getTitle().contains(pageTitle));
    }


    @When("User enters credentials as {string} and {string}")
    public void user_enters_credentials_as_and(String givenUsername, String givenPassword) {
        Faker faker = new Faker();
        String username;
        String password;
        if (givenUsername.equals("Valid")) {
            username = ConfigurationReader.get("username");
        } else if (givenUsername.equals("Invalid")) {
            username = faker.name().username();
        } else {
            username = givenUsername;
        }
        if (givenPassword.equals("Valid")) {
            password = ConfigurationReader.get("password");
        } else if (givenPassword.equals("Invalid")) {
            password = faker.lorem().characters(5, 6, true, true);
        } else {
            password = givenPassword;
        }
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(username, password);

    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage = new LoginPage().wrongCredentialsError.getText().trim();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
