package com.bank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage {

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement newPayeeAlert;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

}
