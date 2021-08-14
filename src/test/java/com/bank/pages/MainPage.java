package com.bank.pages;

import com.bank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//i[@class='icon-signin']")
    public WebElement singInIcon;

}
