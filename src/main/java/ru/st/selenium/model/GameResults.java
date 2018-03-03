package ru.st.selenium.model;

public class GameResults extends TabItem {
    private String club;
    private String tournament;
    private String ratingTable;
    private String moderator;

    public GameResults(String title, String slug, String club, String tournament, String ratingTable, String moderator) {
        this.title = title;
        this.slug = slug;
        this.club = club;
        this.tournament = tournament;
        this.ratingTable = ratingTable;
        this.moderator = moderator;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getRatingTable() {
        return ratingTable;
    }

    public void setRatingTable(String ratingTable) {
        this.ratingTable = ratingTable;
    }

    public String getModerator() {
        return moderator;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }
}
