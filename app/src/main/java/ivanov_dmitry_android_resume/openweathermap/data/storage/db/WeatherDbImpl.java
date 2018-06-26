package ivanov_dmitry_android_resume.openweathermap.data.storage.db;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.domain.mapper.CityCatalogEntityMapper;

public class WeatherDbImpl implements WeatherDb {
    private WeatherRoomDatabase mDatabase;

    @Inject
    public WeatherDbImpl(WeatherRoomDatabase database) {
        this.mDatabase = database;
    }

    @Override
    public Single<List<CityCatalogEntity>> getCities() {
        return mDatabase.cityDao().getAll();
    }

    @Override
    public Completable insertCity(final CityCatalogEntity city) {
        return Completable.fromAction(() -> mDatabase.cityDao().insert(city));
    }

}
