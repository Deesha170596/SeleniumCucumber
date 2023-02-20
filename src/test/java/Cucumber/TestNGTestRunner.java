package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features/SubmitOrder.feature",
glue={"StepDefinations"},
monochrome = true,
plugin={"pretty","junit:target/JUNITReports/reports.xml",
		"json:target/cucumber.json",
		"html:target/HtmlReports"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
