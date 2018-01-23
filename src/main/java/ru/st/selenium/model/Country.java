package ru.st.selenium.model;

public class Country {
    private String title;
    private String aboutCountry;
    private String rusTitle;
    private String rusAboutCountry;

    public Country(String title, String aboutCountry, String rusTitle, String rusAboutCountry) {
        this.title = title;
        this.aboutCountry = aboutCountry;
        this.rusTitle = rusTitle;
        this.rusAboutCountry = rusAboutCountry;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAboutCountry() {
        return aboutCountry;
    }

    public void setAboutCountry(String aboutCountry) {
        this.aboutCountry = aboutCountry;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public void setRusTitle(String rusTitle) {
        this.rusTitle = rusTitle;
    }

    public String getRusAboutCountry() {
        return rusAboutCountry;
    }

    public void setRusAboutCountry(String rusAboutCountry) {
        this.rusAboutCountry = rusAboutCountry;
    }
}
