package ru.st.selenium.model;

public class Club extends TabItem{
    private String city;
    private String country;
    private String admins;
    private String ratingTable;
    private boolean privateClub;
    private String rusCountry;

    public Club(String title, String slug, String city, String countries, String admins, String ratingTable, boolean privateClub, String text, String rusText) {
        this.title = title;
        this.slug = slug;
        this.city = city;
        this.country = countries;
        this.admins = admins;
        this.ratingTable = ratingTable;
        this.privateClub = privateClub;
        this.text = text;
        if (countries == "USA") rusCountry = "США";
        else if (countries == "Russia") rusCountry = "Россия";
        else if (countries == "Ukraine") rusCountry = "Украина";
        else if (countries == "Armenia") rusCountry = "Армения";
        else if (countries == "Canada") rusCountry = "Канада";
        else if (countries == "Mexico") rusCountry = "Мексика";
        else rusCountry = "";
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countries) {
        this.country = countries;
    }

    public String getAdmins() {
        return admins;
    }

    public void setAdmins(String admins) {
        this.admins = admins;
    }

    public String getRatingTable() {
        return ratingTable;
    }

    public void setRatingTable(String ratingTable) {
        this.ratingTable = ratingTable;
    }

    public boolean isPrivateClub() {
        return privateClub;
    }

    public void setPrivateClub(boolean priveteClub) {
        this.privateClub = priveteClub;
    }


    public String getRusCountry() {
        return rusCountry;
    }

    public void setRusCountry(String rusCountry) {
        this.rusCountry = rusCountry;
    }


}
