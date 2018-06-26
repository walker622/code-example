package ivanov_dmitry_android_resume.openweathermap.data.storage.network;

import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.data.entity.WeatherDetailEntity;

public interface WeatherNetwork {
    Single<WeatherDetailEntity> getWeekForecastByCity(String city);
}
