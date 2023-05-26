package com.example.bigjobapplication.bean;

import java.util.Objects;

public class Solar {
    private int id;
    private String solarName;
    private String date;
    private String description;
    private String url;
    private String food;

    public Solar() {
    }

    public Solar(String solarName, String date, String description, String url, String food) {
        this.solarName = solarName;
        this.date = date;
        this.description = description;
        this.url = url;
        this.food = food;
    }

    public Solar(int id, String solarName, String date, String description, String url, String food) {
        this.id = id;
        this.solarName = solarName;
        this.date = date;
        this.description = description;
        this.url = url;
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolarName() {
        return solarName;
    }

    public void setSolarName(String solarName) {
        this.solarName = solarName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solar solar = (Solar) o;
        return id == solar.id && Objects.equals(solarName, solar.solarName) && Objects.equals(date, solar.date) && Objects.equals(description, solar.description) && Objects.equals(url, solar.url) && Objects.equals(food, solar.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, solarName, date, description, url, food);
    }

    @Override
    public String toString() {
        return "Solar{" +
                "id=" + id +
                ", solarName='" + solarName + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
