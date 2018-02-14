package ru.st.selenium.applogic;

import ru.st.selenium.model.User;

public interface ShopHelper {
    void buyItemOnShopPage(String nameOfItem) throws InterruptedException;
    void checkItemInCart(String nameOfItem);
    void removeItemFromCart(String nameOfItem);
    void buyItemsInCart(User user);
}
