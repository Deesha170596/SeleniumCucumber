package com.qa.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.PageObject.CartPage;
import com.qa.PageObject.CheckOutPage;
import com.qa.PageObject.ConfirmationPage;
import com.qa.PageObject.ProductCatalog;
import com.qa.basetest.BaseTest;

public class SubmitOrder extends BaseTest{
@Test	
public  void standalonetest() throws InterruptedException, IOException
{
	String productName="ZARA COAT 3";
	ProductCatalog productcatalogue=login.loginApplication("deeshashetty17@gmail.com", "Deesh@@#17");
	List<WebElement>products = productcatalogue.getProductList();
	productcatalogue.addProductToCart(productName);
	CartPage cartpage=productcatalogue.goToCartPage();
	Boolean match=cartpage.verifyProductDisplay(productName);
	Assert.assertTrue(match);
	CheckOutPage checkoutpage=cartpage.goToCheckout();
	checkoutpage.selectCountry("India");
	ConfirmationPage confirmationpage=checkoutpage.submitOrder();
	String confirmMessage=confirmationpage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}
}
