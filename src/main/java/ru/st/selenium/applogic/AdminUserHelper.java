package ru.st.selenium.applogic;

import ru.st.selenium.model.User;

public interface AdminUserHelper {
    void logindAs(User user);
    void logout();
    void removeUserFromDB(User user);

    boolean isLoggedIn();
}
