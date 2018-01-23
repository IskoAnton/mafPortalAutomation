package ru.st.selenium.applogic2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.st.selenium.applogic.AdminUserHelper;
import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.model.User;
import static org.testng.AssertJUnit.assertEquals;

public class AdminUserHelper2 extends DriverBasedHelper implements AdminUserHelper {
    public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public AdminUserHelper2(ApplicationManager2 manager) {
        super(manager.getWebDriver());
    }

    @Override
    public void logindAs(User user) {
        try {
            pages.internalPage.clickLogo();
        } catch (Exception e) {
            pages.adminInternalPage.clickLogo();
        }
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl != null && currentUrl.length() > 0 && currentUrl.charAt(currentUrl.length() - 1) == 'u' && currentUrl.charAt(currentUrl.length() - 2) == 'r') {
            currentUrl = currentUrl.substring(0, currentUrl.length() - 2);
        }
        if (currentUrl != null && currentUrl.length() > 0 && currentUrl.charAt(currentUrl.length() - 1) == 'n' && currentUrl.charAt(currentUrl.length() - 2) == 'e') {
            currentUrl = currentUrl.substring(0, currentUrl.length() - 2);
        }

        driver.get(currentUrl + "/admin");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isLoggedIn()) {
            logout();
        }
        pages.adminLoginPage.typeEmailField(user.getLogin());
        pages.adminLoginPage.typePasswordField(user.getPassword());
        pages.adminLoginPage.clickLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        pages.adminInternalPage.clickLogoutButton();
        pages.adminLoginPage.ensurePageLoaded();
    }

    public void removeUserFromDB(User user) {
        pages.adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        pages.adminInternalPage.clickOnAdminTab("Users");
        pages.adminUsersPage.ensurePageLoaded();
        pages.adminUsersPage.typeToSearchField(user.getLogin());
        pages.adminUsersPage.pressDeleteUser(user);
    }

    @Override
    public boolean isLoggedIn() {
        try{
            driver.findElement(By.xpath("//div[@class = 'navbar-custom-menu']//a[contains(text(), 'Зарегистрироваться') or contains(text(), 'Register')]"));
            return false;
        } catch (Exception e) {
            return true;
        }
    }


}
