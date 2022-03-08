package com.cutomFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ApplicationaccessCutomLocator extends By	{
		String customlocator;
		public ApplicationaccessCutomLocator(String customlocator){
			this.customlocator=customlocator;
		}
		
		@Override
		public List<WebElement> findElements(SearchContext context) {
			List<WebElement> mockElements = context.findElements(By.xpath("//td[text()='" + customlocator + "'"+"]/ancestor::tr/child::td//i[@class='add_circle clickable']"));
	         return mockElements;
		}
	}