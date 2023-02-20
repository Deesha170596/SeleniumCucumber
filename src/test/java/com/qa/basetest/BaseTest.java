package com.qa.basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.PageObject.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{
	public WebDriver driver;
	public LoginPage login;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		login=new LoginPage(driver);
		login.goTo();
		return login;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
