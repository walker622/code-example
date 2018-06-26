package ivanov_dmitry_android_resume.openweathermap.presentation.catalog;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ivanov_dmitry_android_resume.openweathermap.domain.mapper.CityCatalogEntityMapper;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ActivityScope;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.AddCity;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.GetCityCatalog;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherRepository;

@Module
public abstract class CityCatalogModule {

    @ActivityScope
    @Binds
    public abstract CityCatalogContract.View provideView(CityCatalogActivity catalogActivity);

    @ActivityScope
    @Provides
    static GetCityCatalog provideGetCityCatalog(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler, WeatherRepository weatherRepository, CityCatalogEntityMapper mapper) {
        return new GetCityCatalog(executorScheduler, observerScheduler, weatherRepository, mapper);
    }

    @ActivityScope
    @Provides
    static AddCity provideAddCity(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler, WeatherRepository weatherRepository, CityCatalogEntityMapper mapper) {
        return new AddCity(executorScheduler, observerScheduler, weatherRepository, mapper);
    }

    @ActivityScope
    @Provides
    static CityCatalogContract.Presenter providePresenter(CityCatalogContract.View view, GetCityCatalog getCityCatalog, AddCity addCity) {
        return new CityCatalogPresenter(view, getCityCatalog, addCity);
    }

    @ActivityScope
    @Provides
    static CityCatalogEntityMapper provideCityCatalogMapper() {
        return new CityCatalogEntityMapper();
    }


}
