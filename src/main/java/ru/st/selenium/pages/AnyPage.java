package ru.st.selenium.pages;

import org.openqa.selenium.By;

public abstract class AnyPage extends Page {

	public AnyPage(PageManager pages) {
		super(pages);
	}

	public boolean isAdminPageOnScreen() {
		return isElementPresent(By.xpath("//a[@class = 'sidebar-toggle']"));
	}

	
}
