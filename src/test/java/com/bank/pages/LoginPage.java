package com.bank.pages;

import com.bank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@id = 'user_login']")
    public WebElement username;

    @FindBy(xpath = "//input[@id = 'user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    @FindBy (xpath = "//div[@class = 'alert alert-error']")
    public WebElement wrongCredentialsError;

    public void loginWith(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        signInButton.click();
    }

    public void loginAsDriver(){
        username.sendKeys("username");
        password.sendKeys("password");
        signInButton.click();
        getRidOfSecurityError();
    }

    public void getRidOfSecurityError() {

        List<WebElement> advancedButton = Driver.get().findElements(By.id("details-button"));

        if (advancedButton.size() != 0) {
            advancedButton.get(0).click();
            Driver.get().findElement(By.id("proceed-link")).click();
        }

    }

}
