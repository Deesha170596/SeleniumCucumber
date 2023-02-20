package com.qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getConfirmationMessage() {
		return confirmationMessage.getText();
		}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
}
