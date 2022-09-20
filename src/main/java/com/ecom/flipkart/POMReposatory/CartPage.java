package com.ecom.flipkart.POMReposatory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath ="//a[@class='_2Kn22P gBNbID']" )
	private WebElement productName;
	@FindBy(name =  "q" )
	private WebElement searchField;
	@FindBy(xpath =  "//img[@class='_2xm1JU']" )
	private WebElement homePageLink;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getProductName() {
		return productName;
	}
	public WebElement getSearchField() {
		return searchField;
	}
	public WebElement getHomePageLink() {
		return homePageLink;
	}
	
	
}
