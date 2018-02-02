package ru.st.selenium.model;

public class Permission  extends TabItem{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission(String name) {

        this.name = name;
    }
}
