package ivanov_dmitry_android_resume.openweathermap.data.storage.network;

import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.WeatherDetailEntity;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenWeatherMapService {
    @GET("data/2.5/forecast?cnt=7&units=metric&lang=ru")
    Single<WeatherDetailEntity> getWeekForecast(@Query("q") String city, @Query("appid") String apiKey);
}
