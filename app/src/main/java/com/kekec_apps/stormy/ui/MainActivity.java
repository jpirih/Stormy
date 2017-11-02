package com.kekec_apps.stormy.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.kekec_apps.stormy.R;
import com.kekec_apps.stormy.weather.Current;
import com.kekec_apps.stormy.weather.Forecast;
import java.io.IOException;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    // tag
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String DAILY_FORECAST = "DAILY FORECAST";
    public static final String HOURLY_FORECAST = "HOURLY FORECAST";
    // member varialbes
    private Forecast mForecast;

    @BindView(R.id.timeTextView) TextView mTimeLabel;
    @BindView(R.id.temperatureTextView) TextView mTemperatureLabel;
    @BindView(R.id.humidityValue) TextView mHumidityValue;
    @BindView(R.id.precipValue) TextView mPrecipValue;
    @BindView(R.id.summaryLabel) TextView mSummaryLabel;
    @BindView(R.id.iconImageView) ImageView mIconImageView;
    @BindView(R.id.locationTextView) TextView mLocationLabel;
    @BindView(R.id.refreshimageView) ImageView mRefreshImageView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.INVISIBLE);
        // refresh button
        mRefreshImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getForecast();
            }
        });

        if (!isNetworkAvailable()) {
            Toast.makeText(this, R.string.network_message, Toast.LENGTH_LONG).show();
        }
        toggleRefresh();
        getForecast();

        Log.v(TAG, "UI in App is running");
    }

    public void getForecast() {
        // connection data
        String apiKey = "42f999f60e30c77921e532020c5ff3e6";
        double latitude = 46.056946;
        double longitude = 14.505751;
        HttpUrl forecastUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.darksky.net")
                .addPathSegment("forecast")
                .addPathSegment(apiKey)
                .addPathSegment(latitude + "," + longitude)
                .addQueryParameter("lang", "sl")
                .addQueryParameter("units", "si")
                .build();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(forecastUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Ops sometning went wrong");
                }
                String jsonData = response.body().string();
                Gson gson = new Gson();
                 mForecast = gson.fromJson(jsonData, Forecast.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateDisplay();
                    }
                });
            }
        });
    }
    // methods
    private void toggleRefresh() {
        if (mProgressBar.getVisibility() == View.INVISIBLE) {
            mProgressBar.setVisibility(View.VISIBLE);
            mRefreshImageView.setVisibility(View.INVISIBLE);
        }
        else{
            mProgressBar.setVisibility(View.INVISIBLE);
            mRefreshImageView.setVisibility(View.VISIBLE);
        }
    }
    private void updateDisplay() {
        toggleRefresh();
        Current current = mForecast.getCurrently();
        mTimeLabel.setText(getString(R.string.current_time_label, current.getFormattedTime( mForecast.getTimezone())));
        mLocationLabel.setText(R.string.current_location_label);
        mTemperatureLabel.setText(getString(R.string.current_temperature, current.getTemperature()));
        mHumidityValue.setText(getString(R.string.current_humidity, current.getHumidity()));
        mPrecipValue.setText(getString(R.string.current_rain_prob, current.getPrecipProbability()));
        mSummaryLabel.setText(current.getSummary());
        Drawable drawable = getResources().getDrawable(current.getIconId());
        mIconImageView.setImageDrawable(drawable);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }
    @OnClick (R.id.dailyButton)
    public void startDailyActivity(View view){
        Intent intent = new Intent(this, DailyForecastActivity.class);
        intent.putExtra(DAILY_FORECAST, mForecast.getDaily().getData());
        startActivity(intent);
    }

    @OnClick(R.id.hourlyButton)
    public void startHourlyActivity(View view){
        Intent intent = new Intent(this, HourlyForecastActivity.class);
        intent.putExtra(HOURLY_FORECAST, mForecast.getHourly().getData());
        startActivity(intent);
    }
}
