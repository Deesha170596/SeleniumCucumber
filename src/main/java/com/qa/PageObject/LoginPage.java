package com.qa.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		//sending driver from child to parent through super()
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductCatalog loginApplication(String emailid,String password) {
		email.sendKeys(emailid);
		pwd.sendKeys(password);
		loginbtn.click();
		ProductCatalog productcatalogue=new ProductCatalog(driver);
		return productcatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	@FindBy(id="userEmail")
	WebElement email;
	@FindBy(id="userPassword")
	WebElement pwd;
	@FindBy(id="login")
	WebElement loginbtn;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
}

