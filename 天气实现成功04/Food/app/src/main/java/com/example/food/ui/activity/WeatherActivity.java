// WeatherActivity.java

package com.example.food.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food.MyApplication;
import com.example.food.R;

import api.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherTextView = findViewById(R.id.tvWeatherInfo);


        if (MyApplication.getInstance() != null) {
            getWeather("Beijing");
        } else {
            // 如果 MyApplication 的实例为空，可以进行适当处理或者输出日志信息进行调试
            Log.e("WeatherActivity", "MyApplication instance is null");
        }

    }




    private void getWeather(String city) {
        MyApplication.getInstance().getWeatherApiService().getWeather(city, "e00305400fed1534094725113c8ef5f0")
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        
                        
                        
                        if (response.isSuccessful()) {
                            WeatherResponse weatherResponse = response.body();
                            if (weatherResponse != null) {
                                displayWeatherInfo(weatherResponse);
                            }
                        } else {
                            weatherTextView.setText("获取天气数据失败");
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        weatherTextView.setText("获取数据失败");
                    }
                });
    }

    private void displayWeatherInfo(WeatherResponse weatherResponse) {
        if (weatherResponse != null && weatherResponse.getMain() != null) {

            String cityName = weatherResponse.getName();
            String temperature = translateTemperature(weatherResponse.getMain().getTemp());
            String weatherDescription = translateWeatherDescription(weatherResponse.getWeather().get(0).getDescription());
            int pressure = weatherResponse.getMain().getPressure();
            int humidity = weatherResponse.getMain().getHumidity();

            String weatherInfo = "城市: " + cityName +
                    "\n温度: " + temperature +
                    "\n描述: " + weatherDescription +
                    "\n气压: " + pressure + " hPa" +
                    "\n湿度: " + humidity + "%";
            weatherTextView.setText(weatherInfo);
        } else {
//            String cityName = weatherResponse.getName();
//            String temperature = translateTemperature(weatherResponse.getMain().getTemp());
//            String weatherDescription = translateWeatherDescription(weatherResponse.getWeather().get(0).getDescription());
//            int pressure = weatherResponse.getMain().getPressure();
//            int humidity = weatherResponse.getMain().getHumidity();
//
//            String weatherInfo = "城市: " + cityName +
//                    "\n温度: " + temperature +
//                    "\n描述: " + weatherDescription +
//                    "\n气压: " + pressure + " hPa" +
//                    "\n湿度: " + humidity + "%";
//            weatherTextView.setText(weatherInfo);

            weatherTextView.setText("天气信息为空或不完整");

        }
    }


    private String translateWeatherDescription(String description) {
        switch (description.toLowerCase()) {
            case "clear sky":
                return "晴朗";
            case "few clouds":
                return "少云";
            case "scattered clouds":
                return "散云";
            case "broken clouds":
                return "多云";
            case "shower rain":
                return "阵雨";
            case "rain":
                return "雨";
            case "thunderstorm":
                return "雷暴";
            case "snow":
                return "雪";
            case "mist":
                return "雾";
            default:
                return description;
        }
    }

    private String translateTemperature(double tempKelvin) {
        double tempCelsius = tempKelvin - 273.15;
        return String.format("%.2f°C", tempCelsius);
    }
}
