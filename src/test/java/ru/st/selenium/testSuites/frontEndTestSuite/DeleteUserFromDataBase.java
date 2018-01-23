package ru.st.selenium.testSuites.frontEndTestSuite;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

public class DeleteUserFromDataBase extends TestBase {
    public static final Logger log = Logger.getLogger(ForgotPasswordTest.class.getName());

    @Test
    public void deleteUserFromDataBase() throws Exception {
        User user = TESTUSER;
        app.getAdminUserHelper().logindAs(TESTADMIN);
        app.getAdminUserHelper().removeUserFromDB(user);
    }
}
