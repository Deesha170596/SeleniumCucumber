package com.qa.PageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckout() {
		Actions actions = new Actions(driver);
		actions.moveToElement(checkoutEle).click().build().perform();
		return new CheckOutPage(driver);
	}
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;

	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
}
