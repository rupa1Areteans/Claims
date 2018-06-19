package com.cucumber.framework.runner.login;






import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/login/login.feature" }, 
glue = {
		"classpath:com.cucumber.framework.stepdefinition.login",
		"classpath:com.cucumber.framework.helper",
		"classpath:com.cucumber.framework.configreader",
		"classpath:com.cucumber.framework.configuration.browser",
		"classpath:com.cucumber.framework.PageObject",
		"classpath:com.cucumber.framework.utility"}, 
plugin = {"html:target/cucumber-html-report",
		"json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt",
		"junit:target/cucumber-results.xml"})

public class LoginRunner extends AbstractTestNGCucumberTests {
	
	

}
