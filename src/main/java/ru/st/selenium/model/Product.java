package ru.st.selenium.model;

public class Product {
    private String title;
    private String desription;
    private String price;

    public Product(String title, String desription, String price) {
        this.title = title;
        this.desription = desription;
        this.price = price;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
