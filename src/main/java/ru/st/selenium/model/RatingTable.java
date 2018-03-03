package ru.st.selenium.model;

public class RatingTable extends TabItem{
    private String club;
    private String winCitizen;
    private String winSheriff;
    private String winMafia;
    private String winDon;
    private String failCitizen;
    private String failSheriff;
    private String failMafia;
    private String failDon;
    private String bestPlayer;
    private String bestStep;
    private String coolPlayer;
    private String primaNota3;
    private String primaNota2;
    private String formula;
    private boolean showInGlobal;

    public RatingTable(String title, String club, String winCitizen, String winSheriff, String winMafia, String winDon, String failCitizen, String failSheriff, String failMafia, String failDon, String bestPlayer, String bestStep, String coolPlayer, String primaNota3, String primaNota2, String formula, boolean showInGlobal) {
        this.title = title;
        this.club = club;
        this.winCitizen = winCitizen;
        this.winSheriff = winSheriff;
        this.winMafia = winMafia;
        this.winDon = winDon;
        this.failCitizen = failCitizen;
        this.failSheriff = failSheriff;
        this.failMafia = failMafia;
        this.failDon = failDon;
        this.bestPlayer = bestPlayer;
        this.bestStep = bestStep;
        this.coolPlayer = coolPlayer;
        this.primaNota3 = primaNota3;
        this.primaNota2 = primaNota2;
        this.formula = formula;
        this.showInGlobal = showInGlobal;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getWinCitizen() {
        return winCitizen;
    }

    public void setWinCitizen(String winCitizen) {
        this.winCitizen = winCitizen;
    }

    public String getWinSheriff() {
        return winSheriff;
    }

    public void setWinSheriff(String winSheriff) {
        this.winSheriff = winSheriff;
    }

    public String getWinMafia() {
        return winMafia;
    }

    public void setWinMafia(String winMafia) {
        this.winMafia = winMafia;
    }

    public String getWinDon() {
        return winDon;
    }

    public void setWinDon(String winDon) {
        this.winDon = winDon;
    }

    public String getFailCitizen() {
        return failCitizen;
    }

    public void setFailCitizen(String failCitizen) {
        this.failCitizen = failCitizen;
    }

    public String getFailSheriff() {
        return failSheriff;
    }

    public void setFailSheriff(String failSheriff) {
        this.failSheriff = failSheriff;
    }

    public String getFailMafia() {
        return failMafia;
    }

    public void setFailMafia(String failMafia) {
        this.failMafia = failMafia;
    }

    public String getFailDon() {
        return failDon;
    }

    public void setFailDon(String failDon) {
        this.failDon = failDon;
    }

    public String getBestPlayer() {
        return bestPlayer;
    }

    public void setBestPlayer(String bestPlayer) {
        this.bestPlayer = bestPlayer;
    }

    public String getBestStep() {
        return bestStep;
    }

    public void setBestStep(String bestStep) {
        this.bestStep = bestStep;
    }

    public String getCoolPlayer() {
        return coolPlayer;
    }

    public void setCoolPlayer(String coolPlayer) {
        this.coolPlayer = coolPlayer;
    }

    public String getPrimaNota3() {
        return primaNota3;
    }

    public void setPrimaNota3(String primaNota3) {
        this.primaNota3 = primaNota3;
    }

    public String getPrimaNota2() {
        return primaNota2;
    }

    public void setPrimaNota2(String primaNota2) {
        this.primaNota2 = primaNota2;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public boolean isShowInGlobal() {
        return showInGlobal;
    }

    public void setShowInGlobal(boolean showInGlobal) {
        this.showInGlobal = showInGlobal;
    }
}
