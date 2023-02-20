package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.PageObject.CartPage;

public class AbstractComponents {
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void waitForElementToAppear(By findby)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}
	public void waitForWebElementToAppear(WebElement findby)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartpage= new CartPage(driver);
		return cartpage;
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
}
