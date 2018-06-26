package ivanov_dmitry_android_resume.openweathermap.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "city_catalog")
public class CityCatalogEntity {

    @PrimaryKey(autoGenerate = true)
    public long uid;

    @SerializedName("city")
    @ColumnInfo(name = "name")
    public String title;

    public CityCatalogEntity() {
    }

}
