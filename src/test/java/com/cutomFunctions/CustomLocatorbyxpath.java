package com.cutomFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class CustomLocatorbyxpath extends By	{
		String customlocator;
		public CustomLocatorbyxpath(String customlocator){
			this.customlocator=customlocator;
		}
		
		@Override
		public List<WebElement> findElements(SearchContext context) {
			List<WebElement> mockElements = context.findElements(By.xpath("//a[text()='" + customlocator + "'"+"]/ancestor::tr/child::td/button"));
	         return mockElements;
		}
	}

//a[text()='SUsername']]/ancestor::tr/child::td/button'

