package ru.st.selenium.webdriver;

import org.openqa.selenium.WebDriver;


/*
 * Class extending HtmlUnitDriver to support BASIC authentication
 * 
 * @author Sebastiano Armeli-Battana
 */
public class AuthenticatedHtmlUnitDriver {
	/*private static String USERNAME;
	private static String PASSWORD;

	public AuthenticatedHtmlUnitDriver() {
	}

	public static WebDriver create(String username, String password) {
		USERNAME = username;
		PASSWORD = password;
		return new AuthenticatedHtmlUnitDriver();
	}

	@Override
	protected WebClient newWebClient(BrowserVersion browserVersion) {
		WebClient client = super.newWebClient(browserVersion);
		DefaultCredentialsProvider provider = new DefaultCredentialsProvider();
		provider.addCredentials(USERNAME, PASSWORD);
		client.setCredentialsProvider(provider);
		return client;
	}*/
}
