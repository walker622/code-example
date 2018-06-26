package ivanov_dmitry_android_resume.openweathermap.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import ivanov_dmitry_android_resume.openweathermap.R;
import ivanov_dmitry_android_resume.openweathermap.data.storage.network.OpenWeatherMapService;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ApplicationScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpModule.class)
public class OpenWeatherMapModule {
    @Provides
    @ApplicationScope
    public OpenWeatherMapService provideApi(Retrofit retrofit) {
        return retrofit.create(OpenWeatherMapService.class);
    }

    @Provides
    public Retrofit provideRetrofit(Context context, OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(context.getString(R.string.base_url))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

}
