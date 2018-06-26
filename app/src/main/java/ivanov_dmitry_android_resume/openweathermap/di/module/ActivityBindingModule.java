package ivanov_dmitry_android_resume.openweathermap.di.module;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ActivityScope;
import ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city.EditCityActivity;
import ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city.EditCityModule;
import ivanov_dmitry_android_resume.openweathermap.presentation.catalog.CityCatalogActivity;
import ivanov_dmitry_android_resume.openweathermap.presentation.catalog.CityCatalogModule;
import ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail.WeatherDetailActivity;
import ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail.WeatherDetailModule;

@Module(includes = AndroidInjectionModule.class)
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = CityCatalogModule.class)
    abstract CityCatalogActivity cityCatalogActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = EditCityModule.class)
    abstract EditCityActivity editCityActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = WeatherDetailModule.class)
    abstract WeatherDetailActivity weatherDetailActivity();

}
