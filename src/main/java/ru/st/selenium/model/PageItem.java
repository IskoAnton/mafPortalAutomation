package ru.st.selenium.model;

public class PageItem extends TabItem{
    private String pageName;

    public PageItem(String pageTitle, String pageName, String pageSlug, String text, String metaTitle, String socialMetaTitle, String metaDescription, String socialMetaDescription, String metaKeywords, String rusPageTitle, String rusText, String rusMetaTitle, String rusSocialMetaTitle, String rusMetaDescription, String rusSocialMetaDescription, String rusMetaKeywords) {
        this.title = pageTitle;
        this.pageName = pageName;
        this.slug = pageSlug;
        this.text = text;
        this.metaTitle = metaTitle;
        this.socialMetaTitle = socialMetaTitle;
        this.metaDescription = metaDescription;
        this.socialMetaDescription = socialMetaDescription;
        this.metaKeywords = metaKeywords;
        this.rusTitle = rusPageTitle;
        this.rusText = rusText;
        this.rusMetaTitle = rusMetaTitle;
        this.rusSocialMetaTitle = rusSocialMetaTitle;
        this.rusMetaDescription = rusMetaDescription;
        this.rusSocialMetaDescription = rusSocialMetaDescription;
        this.rusMetaKeywords = rusMetaKeywords;
    }


    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

}
