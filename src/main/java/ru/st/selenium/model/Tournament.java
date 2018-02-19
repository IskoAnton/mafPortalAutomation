package ru.st.selenium.model;

public class Tournament extends TabItem{
    private String ratingTable;
    private String date;
    private String ratingOverview;
    private String rusRatingOverview;

    public Tournament(String title, String slug, String ratingTable, String date, String descripion, String ratingOverview, String text, String metaTitle, String socialMetaTitle, String metaDescription, String socialMetaDescription, String metaKeywords, String rusTitle, String rusDescripion, String rusRatingOverview, String rusText, String rusMetaTitle, String rusSocialMetaTitle, String rusMetaDescription, String rusSocialMetaDescription, String rusMetaKeywords) {
        this.title = title;
        this.slug = slug;
        this.ratingTable = ratingTable;
        this.date = date;
        this.description = descripion;
        this.ratingOverview = ratingOverview;
        this.text = text;
        this.metaTitle = metaTitle;
        this.socialMetaTitle = socialMetaTitle;
        this.metaDescription = metaDescription;
        this.socialMetaDescription = socialMetaDescription;
        this.metaKeywords = metaKeywords;
        this.rusTitle = rusTitle;
        this.rusDescription = rusDescripion;
        this.rusRatingOverview = rusRatingOverview;
        this.rusText = rusText;
        this.rusMetaTitle = rusMetaTitle;
        this.rusSocialMetaTitle = rusSocialMetaTitle;
        this.rusMetaDescription = rusMetaDescription;
        this.rusSocialMetaDescription = rusSocialMetaDescription;
        this.rusMetaKeywords = rusMetaKeywords;
    }


     public String getRatingTable() {
        return ratingTable;
    }

    public void setRatingTable(String ratingTable) {
        this.ratingTable = ratingTable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRatingOverview() {
        return ratingOverview;
    }

    public void setRatingOverview(String ratingOverview) {
        this.ratingOverview = ratingOverview;
    }

    public String getRusRatingOverview() {
        return rusRatingOverview;
    }

    public void setRusRatingOverview(String rusRatingOverview) {
        this.rusRatingOverview = rusRatingOverview;
    }


}
