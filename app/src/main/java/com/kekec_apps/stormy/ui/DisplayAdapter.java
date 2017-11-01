package com.kekec_apps.stormy.ui;

import com.kekec_apps.stormy.weather.Forecast;

public class DisplayAdapter {
    private Forecast  mForecast;

    public void setData(Forecast forecast){
        this.mForecast = forecast;
    }

    public Forecast getForecast(){
        return mForecast;
    }



}
