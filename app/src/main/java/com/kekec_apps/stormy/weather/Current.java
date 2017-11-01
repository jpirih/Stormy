package com.kekec_apps.stormy.weather;

import android.annotation.SuppressLint;

import com.kekec_apps.stormy.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Current {

   private long time;
   private String summary;
   private String icon;
   private double temperature;
   private double humidity;
   private double pressure;
   private double precipProbability;

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

   public double getPrecipProbability() {
      return precipProbability;
   }

   public void setPrecipProbability(double precipProbability) {
      this.precipProbability = precipProbability;
   }


       public int getIconId() {
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

    public String getFormattedTime(String timezone) {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("H:mm");
        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        Date datTime = new Date(getTime() * 1000);
        String timeString = formatter.format(datTime);

        return timeString;
    }


}
