package ivanov_dmitry_android_resume.openweathermap.data.storage.db;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityEntity;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;

public interface WeatherDb {
    Single<List<CityCatalogEntity>> getCities();

    Completable insertCity(CityCatalogEntity city);
}
