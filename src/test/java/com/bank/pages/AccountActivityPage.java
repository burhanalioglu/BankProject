package com.bank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement toAmount;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> dateResults;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> descriptionResults;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]")
    public List<WebElement> depositResults;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]")
    public List<WebElement> withdrawalResults;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> allTransactionsTableHeaderList;

    @FindBy(id = "aa_type")
    public WebElement typeDropdown;

    public List<Date> getListOfDateResults() {
        List<Date> dateList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (WebElement dateResult : dateResults) {
            System.out.println(dateResult.getText());
            try {
                Date eachDate = dateFormat.parse(dateResult.getText());
                dateList.add(eachDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("dateList = " + dateList);
        return dateList;
    }


    public List<String> getMoneyActivitiyList(String depositOrWithdrawal) {
        List<String> moneyActivityList = new ArrayList<>();

        switch (depositOrWithdrawal) {
            case "Deposit":
                for (WebElement depositResult : depositResults) {
                    if (!depositResult.getText().equals("")) {
                        moneyActivityList.add(depositResult.getText());
                    }
                }

                break;
            case "Withdrawal":
                for (WebElement withdrawalResult : withdrawalResults) {
                    if (!withdrawalResult.getText().equals("")) {
                        moneyActivityList.add(withdrawalResult.getText());
                    }
                }
        }
        System.out.println("moneyActivityList = " + moneyActivityList);
        return moneyActivityList;
    }

}
