package com.kekec_apps.stormy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kekec_apps.stormy.R;
import com.kekec_apps.stormy.weather.Hour;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder> {
    private Context mContext;
    private Hour[] mHours;

    public HourAdapter(Context context, Hour[] hours){
        this.mContext = context;
        this.mHours = hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.hourly_list_item, parent, false);

        HourViewHolder viewHolder = new HourViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.timeLabel) TextView mTimeLabel;
        @BindView(R.id.summaryLabel) TextView mSummaryLabel;
        @BindView(R.id.temperatureLabel) TextView mTemperatureLabel;
        @BindView(R.id.weatherIconImageView) ImageView mIconImage;

        public HourViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bindHour(Hour hour){
            mTimeLabel.setText(hour.showTimeHours());
            mSummaryLabel.setText(hour.getSummary());
            mTemperatureLabel.setText(mContext.getString(R.string.hourly_temperature, hour.getTemperature()));
            mIconImage.setImageResource(hour.getIconId());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String time = mTimeLabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String summary = mSummaryLabel.getText().toString();
            String message = String.format("At %s will be %s with %s °C",
                    time, summary, temperature);

            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }

}
