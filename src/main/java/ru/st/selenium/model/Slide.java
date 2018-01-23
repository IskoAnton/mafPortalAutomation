package ru.st.selenium.model;

public class Slide {
    private String title;
    private String description;
    private String buttonText;
    private String buttonLink;
    private String rusTitle;
    private String rusDescription;
    private String rusButtonText;

    public Slide(String title, String description, String buttonText, String buttonLink, String rusTitle, String rusDescription, String rusButtonText, String rusButtonLink) {
        this.title = title;
        this.description = description;
        this.buttonText = buttonText;
        this.buttonLink = buttonLink;
        this.rusTitle = rusTitle;
        this.rusDescription = rusDescription;
        this.rusButtonText = rusButtonText;
        this.rusButtonLink = rusButtonLink;
    }

    private String rusButtonLink;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String butonLink) {
        this.buttonLink = butonLink;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public void setRusTitle(String rusTitle) {
        this.rusTitle = rusTitle;
    }

    public String getRusDescription() {
        return rusDescription;
    }

    public void setRusDescription(String rusDescription) {
        this.rusDescription = rusDescription;
    }

    public String getRusButtonText() {
        return rusButtonText;
    }

    public void setRusButtonText(String rusButtonText) {
        this.rusButtonText = rusButtonText;
    }

    public String getRusButtonLink() {
        return rusButtonLink;
    }

    public void setRusButtonLink(String rusButtonLink) {
        this.rusButtonLink = rusButtonLink;
    }
}
