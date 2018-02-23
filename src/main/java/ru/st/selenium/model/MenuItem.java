package ru.st.selenium.model;

public class MenuItem extends TabItem{
    private String label;
    private String rusLabel;
    private String parentPage;
    private String type;

    private String rusType;
    private String pageOrLinkValue;

    public MenuItem(String label, String rusLabel, String parentPage, String type, String pageOrLinkValue) {
        this.label = label;
        this.rusLabel = rusLabel;
        this.parentPage = parentPage;
        this.type = type;
        if (type.equals("Page link")) {
            this.rusType = "Ссылка на страницу";
        } else if (type.equals("Internal link")) {
            this.rusType = "Внутренняя ссылка";
        } else if (type.equals("External link")) {
            this.rusType = "Внешняя ссылка";
        }
        this.pageOrLinkValue = pageOrLinkValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRusLabel() {
        return rusLabel;
    }

    public void setRusLabel(String rusLabel) {
        this.rusLabel = rusLabel;
    }

    public String getParentPage() {
        return parentPage;
    }

    public void setParentPage(String parentPage) {
        this.parentPage = parentPage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPageOrLinkValue() {
        return pageOrLinkValue;
    }

    public void setPageOrLinkValue(String pageOrLinkValue) {
        this.pageOrLinkValue = pageOrLinkValue;
    }

    public String getRusType() {
        return rusType;
    }

    public void setRusType(String rusType) {
        this.rusType = rusType;
    }




}
