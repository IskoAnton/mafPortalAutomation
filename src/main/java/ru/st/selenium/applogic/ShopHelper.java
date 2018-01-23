package ru.st.selenium.applogic;

public interface ShopHelper {
    void buyItem(String nameOfItem) throws InterruptedException;
    void checkItemInCart(String nameOfItem);
    void removeItemFromCart(String nameOfItem);
}
