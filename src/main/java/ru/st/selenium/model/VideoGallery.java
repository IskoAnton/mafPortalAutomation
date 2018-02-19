package ru.st.selenium.model;

public class VideoGallery extends TabItem{
    private String club;
    private String tournament;
    private String rusTournament;
    private boolean showInGlobalGallery;
    private String youtubeLink;

    public VideoGallery(String title, String rusTitle, String club, String tournament, String rusTournament, boolean showInGlobalGallery, String youtubeLink) {
        this.title = title;
        this.rusTitle = rusTitle;
        this.club = club;
        this.tournament = tournament;
        this.rusTournament = rusTournament;
        this.showInGlobalGallery = showInGlobalGallery;
        this.youtubeLink = youtubeLink;
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

    public boolean isShowInGlobalGallery() {
        return showInGlobalGallery;
    }

    public void setShowInGlobalGallery(boolean showInGlobalGallery) {
        this.showInGlobalGallery = showInGlobalGallery;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getRusTournament() {
        return rusTournament;
    }

    public void setRusTournament(String rusTournament) {
        this.rusTournament = rusTournament;
    }
}
