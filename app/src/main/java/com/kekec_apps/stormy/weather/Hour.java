package com.kekec_apps.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hour implements Parcelable {
    private long time;
    private String summary;
    private String icon;
    private double temperature;
    private double humidity;
    private double pressure;

    public Hour(){ }

    private Hour(Parcel in) {
        time = in.readLong();
        summary = in.readString();
        icon = in.readString();
        temperature = in.readDouble();
        humidity = in.readDouble();
        pressure = in.readDouble();
    }
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(time);
        parcel.writeString(summary);
        parcel.writeString(icon);
        parcel.writeDouble(temperature);
        parcel.writeDouble(humidity);
        parcel.writeDouble(pressure);
    }
    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel in) {
            return new Hour(in);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };

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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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

    public int getIconId(){
        return Forecast.getIconId(icon);
    }

    public String showTimeHours(){
        SimpleDateFormat fomratter = new SimpleDateFormat("H:mm");
        Date date = new Date(time * 1000);
        return fomratter.format(date);
    }

}
