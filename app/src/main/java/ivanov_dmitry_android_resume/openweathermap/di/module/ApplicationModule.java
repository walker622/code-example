package ivanov_dmitry_android_resume.openweathermap.di.module;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import ivanov_dmitry_android_resume.openweathermap.R;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherDataRepository;
import ivanov_dmitry_android_resume.openweathermap.data.storage.db.WeatherDb;
import ivanov_dmitry_android_resume.openweathermap.data.storage.db.WeatherDbImpl;
import ivanov_dmitry_android_resume.openweathermap.data.storage.db.WeatherRoomDatabase;
import ivanov_dmitry_android_resume.openweathermap.data.storage.network.OpenWeatherMapService;
import ivanov_dmitry_android_resume.openweathermap.data.storage.network.WeatherNetwork;
import ivanov_dmitry_android_resume.openweathermap.data.storage.network.WeatherNetworkImpl;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ApplicationScope;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherRepository;
import ivanov_dmitry_android_resume.openweathermap.presentation.utils.ExecuteThread;
import ivanov_dmitry_android_resume.openweathermap.presentation.utils.Navigator;
import ivanov_dmitry_android_resume.openweathermap.presentation.utils.UiThread;

@Module
public class ApplicationModule {
    private final Context mContext;

    public ApplicationModule(Application application) {
        mContext = application.getApplicationContext();
    }

    @ApplicationScope
    @Provides
    public Navigator provideNavigator() {
        return new Navigator();
    }

    @ApplicationScope
    @Provides
    public Context provideContext() {
        return mContext;
    }

    @ApplicationScope
    @Provides
    public ObserverScheduler provideObserverScheduler() {
        return new UiThread();
    }

    @ApplicationScope
    @Provides
    public ExecutorScheduler provideExecuterScheduler() {
        return new ExecuteThread();
    }

    @Provides
    public WeatherDb provideWeatherDb(WeatherRoomDatabase roomDatabase) {
        return new WeatherDbImpl(roomDatabase);
    }

    @Provides
    public WeatherNetwork provideWeatherNetwork(OpenWeatherMapService service, Context context) {
        return new WeatherNetworkImpl(service, context.getString(R.string.api_key));
    }

    @ApplicationScope
    @Provides
    public WeatherRoomDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, WeatherRoomDatabase.class, "db").addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                List<String> list = new ArrayList<>();
                list.add("New York");
                list.add("Moscow");
                list.add("Paris");
                list.add("Toronto");
                list.add("Kiev");
                for (int i = 0; i < list.size(); i++) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", list.get(i));
                    db.insert("city_catalog", SQLiteDatabase.CONFLICT_NONE, contentValues);
                }
            }
        }).build();
    }

    @ApplicationScope
    @Provides
    public WeatherRepository provideWeatherRepository(WeatherDb weatherDb, WeatherNetwork weatherNetwork) {
        return new WeatherDataRepository(weatherDb, weatherNetwork);
    }


}
