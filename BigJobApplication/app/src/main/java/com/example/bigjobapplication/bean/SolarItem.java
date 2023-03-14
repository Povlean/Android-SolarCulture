package com.example.bigjobapplication.bean;

public class SolarItem {
    private String solarname;
    private int solarimg;
    private String description;

    public SolarItem() {
    }

    public SolarItem(String solarName, int solarImg) {
        this.solarname = solarName;
        this.solarimg = solarImg;
    }

    public SolarItem(String solarname, String description) {
        this.solarname = solarname;
        this.description = description;
    }

    public SolarItem(String solarName, int solarImg, String description) {
        this.solarname = solarName;
        this.solarimg = solarImg;
        this.description = description;
    }

    public String getSolarName() {
        return solarname;
    }

    public void setSolarName(String solarName) {
        this.solarname = solarName;
    }

    public int getSolarImg() {
        return solarimg;
    }

    public void setSolarImg(int solarImg) {
        this.solarimg = solarImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SolarItem{" +
                "solarName='" + solarname + '\'' +
                ", solarImg=" + solarimg +
                ", description='" + description + '\'' +
                '}';
    }
}
