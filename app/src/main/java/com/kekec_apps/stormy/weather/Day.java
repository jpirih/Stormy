package com.kekec_apps.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Day implements Parcelable {
    // member variables
    private long time;
    private String summary;
    private String icon;
    private long sunriseTime;
    private long sunsetTime;
    private double temperatureMax;
    private double humidity;
    private double pressure;

    // constructor
    public Day(){ }

    // parcelable methods
    private Day(Parcel in) {
        time = in.readLong();
        summary = in.readString();
        icon = in.readString();
        sunriseTime = in.readLong();
        sunsetTime = in.readLong();
        temperatureMax = in.readDouble();
        humidity = in.readDouble();
        pressure = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(time);
        parcel.writeString(summary);
        parcel.writeString(icon);
        parcel.writeLong(sunriseTime);
        parcel.writeLong(sunsetTime);
        parcel.writeDouble(temperatureMax);
        parcel.writeDouble(humidity);
        parcel.writeDouble(pressure);
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    // getters and setters
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

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

    public long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    // data manipulation methods
    public int getIconId(){
        return Forecast.getIconId(icon);
    }

    public String getDayOfTheWeek(){
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        format.setTimeZone(TimeZone.getTimeZone("CET"));
        Date date = new Date(time * 1000);
        return format.format(date);
    }

}
