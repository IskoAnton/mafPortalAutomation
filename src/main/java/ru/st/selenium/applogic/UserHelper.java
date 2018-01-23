package ru.st.selenium.applogic;

import ru.st.selenium.model.User;

public interface UserHelper {

	void loginAs(User user) throws InterruptedException;
	void logout();
	boolean isLoggedIn();
	boolean isLoggedInAs(User user);
	boolean isNotLoggedIn();
	void restorePasswordOfExistingUser(String language, String email);
	void restorePasswordOfNotExistingUser(String language, String email) throws InterruptedException;
	void checkMessageInLoginPage(String message);
	void registerNewUser(String firstName, String lastName, String nickName, String email, String date, String password, String passwordConfirmation);
	void pressRegistrationLinkInEmail() throws Exception;
	void pressResetPasswordLinkInEmail() throws Exception;
	void setNewPasswordAfterRestore(String email, String password, String passwordConfirmation);
	void changeUserPassword(String newPassword);
	boolean isNewMassagesInMailBox();
	String getLanguage();

}
