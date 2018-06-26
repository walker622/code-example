package ivanov_dmitry_android_resume.openweathermap.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.data.entity.WeatherDetailEntity;

public interface WeatherRepository {

    Single<List<CityCatalogEntity>> getCities();

    Completable insertCity(CityCatalogEntity city);

    Single<WeatherDetailEntity> getWeekForecast(String city);

}
