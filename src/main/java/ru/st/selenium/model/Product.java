package ru.st.selenium.model;

public class Product extends TabItem{

    private String price;

    public Product(String title, String description, String price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
