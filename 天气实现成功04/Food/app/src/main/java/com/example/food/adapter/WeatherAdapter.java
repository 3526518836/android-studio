package com.example.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.food.R;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter<String> {

    private ArrayList<String> weatherDataList;
    private LayoutInflater inflater;

    public WeatherAdapter(Context context, ArrayList<String> weatherDataList) {
        super(context, 0, weatherDataList);
        this.weatherDataList = weatherDataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.weather_list_item, parent, false);
            holder = new ViewHolder();
            holder.weatherInfoTextView = convertView.findViewById(R.id.tvWeatherInfo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String weatherInfo = weatherDataList.get(position);
        holder.weatherInfoTextView.setText(weatherInfo);

        return convertView;
    }

    private static class ViewHolder {
        TextView weatherInfoTextView;
    }
}
