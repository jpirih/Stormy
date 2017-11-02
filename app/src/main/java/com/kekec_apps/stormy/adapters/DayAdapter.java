package com.kekec_apps.stormy.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kekec_apps.stormy.R;
import com.kekec_apps.stormy.weather.Day;

public class DayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
         return mDays.length;
    }

    @Override
    public Object getItem(int i) {
        return mDays[i];
    }

    @Override
    public long getItemId(int i) {
        return 0; // not in use
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null){
            // brand new
            view = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImgeView = view.findViewById(R.id.iconImageView);
            holder.temperatureLabel = view.findViewById(R.id.temperatureLabel);
            holder.dayLabel = view.findViewById(R.id.dayNameLabel);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        Day day = mDays[i];
        holder.iconImgeView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(mContext.getString(R.string.daily_temperature, day.getTemperatureMax()));
        if(i != 0){
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }else {
            holder.dayLabel.setText("Today");
        }
        return view;
    }

    private static class ViewHolder {
        public ImageView iconImgeView;
        public TextView temperatureLabel;
        public TextView dayLabel;
    }

}
