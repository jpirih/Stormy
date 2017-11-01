package com.kekec_apps.stormy.weather;

public class HourlyForecast {
    private String summary;
    private String icon;
    private Hour[] data;

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

    public Hour[] getData() {
        return data;
    }

    public void setData(Hour[] data) {
        this.data = data;
    }
}
