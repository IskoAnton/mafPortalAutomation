package ru.st.selenium.applogic;

import org.testng.ITestResult;
import ru.st.selenium.pages.PageManager;

import java.io.IOException;
import java.sql.SQLException;

public interface ApplicationManager {

	UserHelper getUserHelper();
    AdminUserHelper getAdminUserHelper();
	NavigationHelper getNavigationHelper();
    ShopHelper getShopHelper();
    PageManager getPages();
    void takeScreenShotOnFailure(ITestResult testResult, String testName) throws IOException;
    void maximizeBrowser();
    void refreshBrowser();

    void stop();

}
