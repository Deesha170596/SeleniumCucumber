package com.qa.PageObject;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	WebDriver driver;
public CheckOutPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void selectCountry(String countryName)
{
	Actions a=new Actions(driver);
	a.sendKeys(country,countryName).build().perform();
	waitForElementToAppear(By.cssSelector(".ta-results"));
	selectCountry.click();
}

public ConfirmationPage submitOrder() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",submit);
	return new ConfirmationPage(driver);
}

@FindBy(css=".btnn.action__submit.ng-star-inserted")
WebElement submit;
@FindBy(css="[placeholder='Select Country']")
WebElement country;
@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
WebElement selectCountry;

By results=By.cssSelector(".ta-results");
}
