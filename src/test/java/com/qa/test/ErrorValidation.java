package com.qa.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.basetest.BaseTest;

public class ErrorValidation extends BaseTest{
@Test	
public  void standalonetest() throws InterruptedException, IOException
{
	login.loginApplication("deeshashetty17@gmail.com", "Deesh@@#17");
	Assert.assertEquals("Incorrect email or password.",login.getErrorMessage());
}
}
