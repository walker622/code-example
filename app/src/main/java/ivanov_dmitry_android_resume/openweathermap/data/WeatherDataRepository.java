package ivanov_dmitry_android_resume.openweathermap.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.data.entity.WeatherDetailEntity;
import ivanov_dmitry_android_resume.openweathermap.data.storage.db.WeatherDb;
import ivanov_dmitry_android_resume.openweathermap.data.storage.network.WeatherNetwork;

public class WeatherDataRepository implements WeatherRepository {
    private WeatherDb mWeatherDb;
    private WeatherNetwork mWeatherNetwork;

    public WeatherDataRepository(WeatherDb weatherDb, WeatherNetwork weatherNetwork) {
        mWeatherDb = weatherDb;
        mWeatherNetwork = weatherNetwork;
    }

    @Override
    public Single<List<CityCatalogEntity>> getCities() {
        return mWeatherDb.getCities();
    }

    @Override
    public Completable insertCity(CityCatalogEntity city) {
        return mWeatherDb.insertCity(city);
    }

    @Override
    public Single<WeatherDetailEntity> getWeekForecast(String city) {
        return mWeatherNetwork.getWeekForecastByCity(city);
    }


}
