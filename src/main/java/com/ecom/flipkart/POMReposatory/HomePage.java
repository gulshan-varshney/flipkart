package com.ecom.flipkart.POMReposatory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.flipkart.GenericUtility.WebDriverUtility;

public class HomePage  extends WebDriverUtility{
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	

	@FindBy(xpath ="//button[text()='✕']" )
	private WebElement cancelButton;
	@FindBy(name =  "q" )
	private WebElement searchField;
	@FindBy(xpath =  "//button[@class='L0Z3Pu' and @type='submit']" )
	private WebElement searchButton;
	@FindBy(xpath =  "//div[@class='_13oc-S']/*[position()=1]" )
	private WebElement product;
	@FindBy(xpath =  "//img[@class='_2xm1JU']" )
	private WebElement homePageLink;
	@FindBy(xpath =  "//span[text()='Cart']" )
	private WebElement cartPageLink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getHomePageLink() {
		return homePageLink;
	}

	public WebElement getCartPageLink() {
		return cartPageLink;
	}



	



}
