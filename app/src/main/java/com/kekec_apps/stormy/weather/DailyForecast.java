package com.kekec_apps.stormy.weather;

public class DailyForecast {
    private String summary;
    private String icon;
    private Day[] data;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Day[] getData() {
        return data;
    }

    public void setData(Day[] data) {
        this.data = data;
    }
}
