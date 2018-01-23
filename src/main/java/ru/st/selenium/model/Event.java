package ru.st.selenium.model;

import java.util.List;

public class Event {
    private String title;
    private String slug;
    private String date;
    private String ratingTable;
    private List<Club> clubs;
    private String description;
    private String text;
    private String rusTitle;
    private String rusDescription;
    private String rusText;

    public Event(String title, String slug,  String ratingTable, String description, String text, String rusTitle, String rusDescription, String rusText) {
        this.title = title;
        this.slug = slug;
        this.ratingTable = ratingTable;
        this.description = description;
        this.text = text;
        this.rusTitle = rusTitle;
        this.rusDescription = rusDescription;
        this.rusText = rusText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRatingTable() {
        return ratingTable;
    }

    public void setRatingTable(String ratingTable) {
        this.ratingTable = ratingTable;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRusDescription() {
        return rusDescription;
    }

    public void setRusDescription(String rusDescription) {
        this.rusDescription = rusDescription;
    }

    public String getRusText() {
        return rusText;
    }

    public void setRusText(String rusText) {
        this.rusText = rusText;
    }
}
