package com.example.bigjobapplication.bean;

public class SeasonSolar {
    private String SsName;
    private int SsImg;
    private String SsDesc;

    public SeasonSolar(String ssName, int ssImg, String ssDesc) {
        SsName = ssName;
        SsImg = ssImg;
        SsDesc = ssDesc;
    }

    public SeasonSolar(String ssName, int ssImg) {
        SsName = ssName;
        SsImg = ssImg;
    }

    public SeasonSolar() {
    }

    public String getSsName() {
        return SsName;
    }

    public void setSsName(String ssName) {
        SsName = ssName;
    }

    public int getSsImg() {
        return SsImg;
    }

    public void setSsImg(int ssImg) {
        SsImg = ssImg;
    }

    public String getSsDesc() {
        return SsDesc;
    }

    public void setSsDesc(String ssDesc) {
        SsDesc = ssDesc;
    }

    @Override
    public String toString() {
        return "SeasonSolar{" +
                "SsName='" + SsName + '\'' +
                ", SsImg=" + SsImg +
                ", SsDesc='" + SsDesc + '\'' +
                '}';
    }
}
