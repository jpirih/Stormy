package com.kekec_apps.stormy.weather;

import com.kekec_apps.stormy.R;

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

    public static int getIconId(String icon){

        int iconId = R.drawable.clear_day;

        if(icon.equals("clear-day")){
            iconId = R.drawable.clear_day;
        }
        else if (icon.equals("clear-night")){
            iconId = R.drawable.clear_night;
        }
        else if (icon.equals("rain")) {
            iconId = R.drawable.rain;
        }
        else if (icon.equals("snow")) {
            iconId = R.drawable.snow;
        }
        else if (icon.equals("sleet")) {
            iconId = R.drawable.sleet;
        }
        else if (icon.equals("wind")) {
            iconId = R.drawable.wind;
        }
        else if (icon.equals("fog")) {
            iconId = R.drawable.fog;
        }
        else if (icon.equals("cloudy")) {
            iconId = R.drawable.cloudy;
        }
        else if (icon.equals("partly-cloudy-day")) {
            iconId = R.drawable.partly_cloudy;
        }
        else if (icon.equals("partly-cloudy-night")) {
            iconId = R.drawable.cloudy_night;
        }

        return iconId;

    }


}
