@tag
Feature: Purchase the order from Ecommerce website

		Background:
		Given user landed on Ecommerce page

@tag2
		Scenario Outline: Positive test of Submitting the order
		
			Given user logged in with username <name> and password <password>
			When user add the product <productname> to Cart
			And Checkout <productname> and submit the order
			Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

		Examples:
			| name | password | productname |
			| deeshashetty17@gmail.com | Deesh@@#17 | ZARA COAT 3 |