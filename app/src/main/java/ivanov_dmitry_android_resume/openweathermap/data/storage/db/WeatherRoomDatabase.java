package ivanov_dmitry_android_resume.openweathermap.data.storage.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.data.storage.db.dao.CityDao;

@Database(entities = {CityCatalogEntity.class}, version = 1, exportSchema = false)
public abstract class WeatherRoomDatabase extends RoomDatabase {
    public abstract CityDao cityDao();
}
