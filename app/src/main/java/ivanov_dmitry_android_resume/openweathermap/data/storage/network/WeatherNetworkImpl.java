package ivanov_dmitry_android_resume.openweathermap.data.storage.network;

import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.WeatherDetailEntity;

public class WeatherNetworkImpl implements WeatherNetwork {
    private OpenWeatherMapService mOpenWeatherMapService;
    private String apiKey;

    public WeatherNetworkImpl(OpenWeatherMapService openWeatherMapService, String apiKey) {
        mOpenWeatherMapService = openWeatherMapService;
        this.apiKey = apiKey;
    }

    @Override
    public Single<WeatherDetailEntity> getWeekForecastByCity(String city) {
        return mOpenWeatherMapService.getWeekForecast(city, apiKey);
    }
}
