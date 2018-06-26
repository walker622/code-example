package ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ActivityScope;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.weather_detail.GetWeekForecast;
import ivanov_dmitry_android_resume.openweathermap.domain.mapper.WeatherDetailEntityMapper;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherRepository;

@Module
public abstract class WeatherDetailModule {
    @ActivityScope
    @Binds
    public abstract WeatherDetailContract.View provideView(WeatherDetailActivity weatherDetailActivity);

    @ActivityScope
    @Provides
    static WeatherDetailContract.Presenter providePresenter(WeatherDetailContract.View view, GetWeekForecast getWeekForecast) {
        return new WeatherDetailPresenter(view, getWeekForecast);
    }

    @ActivityScope
    @Provides
    static GetWeekForecast provideWeekForecastUseCase(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler, WeatherRepository weatherRepository, WeatherDetailEntityMapper mapper) {
        return new GetWeekForecast(executorScheduler, observerScheduler, weatherRepository, mapper);
    }

    @ActivityScope
    @Provides
    static WeatherDetailEntityMapper provideMapper() {
        return new WeatherDetailEntityMapper();
    }

}
