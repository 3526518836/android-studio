package com.example.food;

import android.app.Activity;
import android.app.Application;

import com.squareup.okhttp.HttpUrl;

import org.litepal.LitePal;

import api.WeatherApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    public static MyApplication Instance;
    private static MyApplication instance;
    private Retrofit retrofit;
    private WeatherApiService weatherApiService;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String CITY = "Beijing,cn";
    private static final String APP_ID = "e00305400fed1534094725113c8ef5f0";
    @Override
    public void onCreate() {

        super.onCreate();
        Instance = this;
        instance =this;
        LitePal.initialize(this);//初始化LitePal数据库retrofit = new Retrofit.Builder()
        setupRetrofit();
    }

    private void setupRetrofit() {
        HttpUrl baseUrl = HttpUrl.parse(BASE_URL + "/")  // 注意这里加上斜杠结尾
                .newBuilder()
                .addQueryParameter("q", CITY)
                .addQueryParameter("APPID", APP_ID)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 创建WeatherApiService实例
        weatherApiService = retrofit.create(WeatherApiService.class);
    }

    public static MyApplication getInstance() {
        return instance;
    }



    public WeatherApiService getWeatherApiService() {
        return weatherApiService;
    }
    private Activity mMainActivity;

    public Activity getMainActivity() {
        return mMainActivity;
    }

    public  void setMainActivity(Activity mainActivity) {
        mMainActivity = mainActivity;
    }
}