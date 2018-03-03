package ru.st.selenium.model;

public class Season extends TabItem{
    String club;

    public Season(String title, String club) {
        this.title = title;
        this.club = club;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
