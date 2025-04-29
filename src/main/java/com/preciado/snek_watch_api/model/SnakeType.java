package com.preciado.snek_watch_api.model;

public class SnakeType {
    private long id;
    private String commonName;
    private String taxonomyName;
    private String careLevel;
    private String overview;
    private int averageLifeSpanInYrs;
    private double averageAdultLengthInFeet;
    private String diet;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCommonName() {
        return commonName;
    }
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }
    public String getTaxonomyName() {
        return taxonomyName;
    }
    public void setTaxonomyName(String taxonomyName) {
        this.taxonomyName = taxonomyName;
    }
    public String getCareLevel() {
        return careLevel;
    }
    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public int getAverageLifeSpanInYrs() {
        return averageLifeSpanInYrs;
    }
    public void setAverageLifeSpanInYrs(int averageLifeSpanInYrs) {
        this.averageLifeSpanInYrs = averageLifeSpanInYrs;
    }
    public double getAverageAdultLengthInFeet() {
        return averageAdultLengthInFeet;
    }
    public void setAverageAdultLengthInFeet(double averageAdultLengthInFeet) {
        this.averageAdultLengthInFeet = averageAdultLengthInFeet;
    }
    public String getDiet() {
        return diet;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }

    
}
