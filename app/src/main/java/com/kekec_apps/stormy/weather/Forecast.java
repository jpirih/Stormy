package com.kekec_apps.stormy.weather;

public class Forecast {
    private String timezone;
    private Current currently;
    private HourlyForecast hourly;
    private DailyForecast daily;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Current getCurrently() {
        return currently;
    }

    public void setCurrently(Current currently) {
        this.currently = currently;
    }

    public HourlyForecast getHourly() {
        return hourly;
    }

    public void setHourly(HourlyForecast hourly) {
        this.hourly = hourly;
    }

    public DailyForecast getDaily() {
        return daily;
    }

    public void setDaily(DailyForecast daily) {
        this.daily = daily;
    }
}
