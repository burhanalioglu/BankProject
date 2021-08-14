package com.bank.pages;


import com.bank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypesList;

    @FindBy(xpath = "//h2[.='Credit Accounts']/following-sibling::*[1]//thead//th")
    public List<WebElement> creditAccountsHeaderList;

    public WebElement getAccount(String accountName) {
        return Driver.get().findElement(By.linkText(accountName));
    }

}
