package ivanov_dmitry_android_resume.openweathermap.domain.interactor.weather_detail;

import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.SingleUseCase;
import ivanov_dmitry_android_resume.openweathermap.domain.mapper.WeatherDetailEntityMapper;
import ivanov_dmitry_android_resume.openweathermap.domain.model.ForecastModel;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherRepository;

public class GetWeekForecast extends SingleUseCase<ForecastModel, String> {
    private WeatherRepository mWeatherRepository;
    private WeatherDetailEntityMapper mMapper;

    public GetWeekForecast(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler, WeatherRepository weatherRepository, WeatherDetailEntityMapper mapper) {
        super(executorScheduler, observerScheduler);
        mWeatherRepository = weatherRepository;
        mMapper = mapper;
    }

    @Override
    public Single<ForecastModel> buildUseCaseObservable(String s) {
        return mWeatherRepository.getWeekForecast(s).map(weatherDetailEntity -> mMapper.fromEntity(weatherDetailEntity));
    }
}
