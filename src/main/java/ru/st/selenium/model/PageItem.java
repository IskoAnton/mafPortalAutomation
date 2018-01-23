package ru.st.selenium.model;

public class PageItem {
    private String pageTitle;
    private String pageName;
    private String pageSlug;
    private String content;
    private String metaTitle;
    private String socialMetaTitle;
    private String metaDescription;
    private String socialMetaDescription;
    private String metaKeywords;

    public PageItem(String pageTitle, String pageName, String pageSlug, String content, String metaTitle, String socialMetaTitle, String metaDescription, String socialMetaDescription, String metaKeywords, String rusPageTitle, String rusContent, String rusMetaTitle, String rusSocialMetaTitle, String rusMetaDescription, String rusSocialMetaDescription, String rusMetaKeywords) {
        this.pageTitle = pageTitle;
        this.pageName = pageName;
        this.pageSlug = pageSlug;
        this.content = content;
        this.metaTitle = metaTitle;
        this.socialMetaTitle = socialMetaTitle;
        this.metaDescription = metaDescription;
        this.socialMetaDescription = socialMetaDescription;
        this.metaKeywords = metaKeywords;
        this.rusPageTitle = rusPageTitle;
        this.rusContent = rusContent;
        this.rusMetaTitle = rusMetaTitle;
        this.rusSocialMetaTitle = rusSocialMetaTitle;
        this.rusMetaDescription = rusMetaDescription;
        this.rusSocialMetaDescription = rusSocialMetaDescription;
        this.rusMetaKeywords = rusMetaKeywords;
    }

    public String getPageTitle() {

        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageSlug() {
        return pageSlug;
    }

    public void setPageSlug(String pageSlug) {
        this.pageSlug = pageSlug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getRusPageTitle() {
        return rusPageTitle;
    }

    public void setRusPageTitle(String rusPageTitle) {
        this.rusPageTitle = rusPageTitle;
    }

    public String getRusContent() {
        return rusContent;
    }

    public void setRusContent(String rusContent) {
        this.rusContent = rusContent;
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

    private String rusPageTitle;
    private String rusContent;
    private String rusMetaTitle;
    private String rusSocialMetaTitle;
    private String rusMetaDescription;
    private String rusSocialMetaDescription;
    private String rusMetaKeywords;
}
