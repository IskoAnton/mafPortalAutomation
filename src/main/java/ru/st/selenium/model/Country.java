package ru.st.selenium.model;

public class Country extends TabItem{
    private String title;
    private String text;
    private String rusTitle;
    private String rusText;

    public Country(String title, String text, String rusTitle, String rusText) {
        this.title = title;
        this.text = text;
        this.rusTitle = rusTitle;
        this.rusText = rusText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public void setRusTitle(String rusTitle) {
        this.rusTitle = rusTitle;
    }

    public String getRusText() {
        return rusText;
    }

    public void setRusText(String rusText) {
        this.rusText = rusText;
    }
}
