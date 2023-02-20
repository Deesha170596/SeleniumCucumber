package StepDefinations;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.qa.PageObject.CartPage;
import com.qa.PageObject.CheckOutPage;
import com.qa.PageObject.ConfirmationPage;
import com.qa.PageObject.LoginPage;
import com.qa.PageObject.ProductCatalog;
import com.qa.basetest.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ECommerce extends BaseTest
{
	
	public LoginPage login;
	public ProductCatalog productcatalogue;
	public ConfirmationPage confirmationpage;
	
	@Given("user landed on Ecommerce page")
	public void user_landed_on_Ecommerce_page() throws IOException
	{
		login=launchApplication();
	}
	
	@Given("^user logged in with username (.+) and password (.+)$")
	public void user_logged_in_with_username_and_password(String username,String password)
	{
		productcatalogue=login.loginApplication(username,password);
	}
	
	@When("^user add the product (.+) to Cart$")
	public void user_add_the_product_to_cart(String productname) throws InterruptedException
	{
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productname);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productname)
	{
		CartPage cartpage=productcatalogue.goToCartPage();
		Boolean match=cartpage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage=cartpage.goToCheckout();
		checkoutpage.selectCountry("India");
		confirmationpage=checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string)
	{
		String confirmMessage=confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
}
