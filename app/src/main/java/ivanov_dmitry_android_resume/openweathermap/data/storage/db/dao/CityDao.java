package ivanov_dmitry_android_resume.openweathermap.data.storage.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;

@Dao
public interface CityDao {
    @Query("SELECT * FROM city_catalog")
    Single<List<CityCatalogEntity>> getAll();

    @Query("SELECT * FROM city_catalog WHERE uid = :id")
    Single<CityCatalogEntity> getById(long id);

    @Insert
    void insert(CityCatalogEntity cityEntity);

    @Update
    void update(CityCatalogEntity cityEntity);

    @Delete
    void delete(CityCatalogEntity cityEntity);
}
