package ru.st.selenium.model;

public class PhotoGallery {
    private String title;
    private String rusTitle;
    private String slug;
    private String club;
    private String tournament;
    public String rusTournament;
    private boolean showInGlobalGallery;

    public PhotoGallery(String title, String rusTitle, String slug, String club, String tournament, String rusTournament, boolean showInGlobalGallery) {
        this.title = title;
        this.rusTitle = rusTitle;
        this.slug = slug;
        this.club = club;
        this.tournament = tournament;
        this.rusTournament = rusTournament;
        this.showInGlobalGallery = showInGlobalGallery;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public void setRusTitle(String rusTitle) {
        this.rusTitle = rusTitle;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getRusTournament() {
        return rusTournament;
    }

    public void setRusTournament(String rusTournament) {
        this.rusTournament = rusTournament;
    }
}
