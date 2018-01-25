package ru.st.selenium.model;

public class News extends TabItem{
    private String title;
    private String slug;
    private String date;
    private String descripion;
    private String text;
    private String metaTitle;
    private String socialMetaTitle;
    private String metaDescription;
    private String socialMetaDescription;
    private String metaKeywords;
    private String rusTitle;
    private String rusDescripion;
    private String rusText;
    private String rusMetaTitle;
    private String rusSocialMetaTitle;
    private String rusMetaDescription;
    private String rusSocialMetaDescription;
    private String rusMetaKeywords;



    public News(String title, String slug, String date, String description, String text, String metaTitle, String socialMetaTitle, String metaDescription, String socialMetaDescription, String metaKeywords, String rusTitle, String rusDescripion, String rusText, String rusMetaTitle, String rusSocialMetaTitle, String rusMetaDescription, String rusSocialMetaDescription, String rusMetaKeywords) {
        this.title = title;
        this.slug = slug;
        this.date = date;
        this.descripion = description;
        this.text = text;

        this.metaTitle = metaTitle;
        this.socialMetaTitle = socialMetaTitle;
        this.metaDescription = metaDescription;
        this.socialMetaDescription = socialMetaDescription;
        this.metaKeywords = metaKeywords;
        this.rusTitle = rusTitle;
        this.rusDescripion = rusDescripion;
        this.rusText = rusText;
        this.rusMetaTitle = rusMetaTitle;
        this.rusSocialMetaTitle = rusSocialMetaTitle;
        this.rusMetaDescription = rusMetaDescription;
        this.rusSocialMetaDescription = rusSocialMetaDescription;
        this.rusMetaKeywords = rusMetaKeywords;
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

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSocialMetaTitle() {
        return socialMetaTitle;
    }

    public void setSocialMetaTitle(String socialMetaTitle) {
        this.socialMetaTitle = socialMetaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getSocialMetaDescription() {
        return socialMetaDescription;
    }

    public void setSocialMetaDescription(String socialMetaDescription) {
        this.socialMetaDescription = socialMetaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getRusDescripion() {
        return rusDescripion;
    }

    public void setRusDescripion(String rusDescripion) {
        this.rusDescripion = rusDescripion;
    }

    public String getRusText() {
        return rusText;
    }

    public void setRusText(String rusText) {
        this.rusText = rusText;
    }

    public String getRusMetaTitle() {
        return rusMetaTitle;
    }

    public void setRusMetaTitle(String rusMetaTitle) {
        this.rusMetaTitle = rusMetaTitle;
    }

    public String getRusSocialMetaTitle() {
        return rusSocialMetaTitle;
    }

    public void setRusSocialMetaTitle(String rusSocialMetaTitle) {
        this.rusSocialMetaTitle = rusSocialMetaTitle;
    }

    public String getRusMetaDescription() {
        return rusMetaDescription;
    }

    public void setRusMetaDescription(String rusMetaDescription) {
        this.rusMetaDescription = rusMetaDescription;
    }

    public String getRusSocialMetaDescription() {
        return rusSocialMetaDescription;
    }

    public void setRusSocialMetaDescription(String rusSocialMetaDescription) {
        this.rusSocialMetaDescription = rusSocialMetaDescription;
    }

    public String getRusMetaKeywords() {
        return rusMetaKeywords;
    }

    public void setRusMetaKeywords(String rusMetaKeywords) {
        this.rusMetaKeywords = rusMetaKeywords;
    }

    public String getRusTitle() {
        return rusTitle;
    }

    public void setRusTitle(String rusTitle) {
        this.rusTitle = rusTitle;
    }


}
