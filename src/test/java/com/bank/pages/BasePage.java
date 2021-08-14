package com.bank.pages;

import com.bank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateTo(String module){
        Driver.get().findElement(By.linkText(module)).click();
    }

}
