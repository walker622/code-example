package ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog;

import javax.inject.Inject;

import io.reactivex.Completable;
import ivanov_dmitry_android_resume.openweathermap.domain.mapper.CityCatalogEntityMapper;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.CompletableUseCase;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.error.CityValidationError;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherRepository;

public class AddCity extends CompletableUseCase<CityModel> {
    private WeatherRepository mWeatherRepository;
    private CityCatalogEntityMapper mMapper;

    @Inject
    public AddCity(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler, WeatherRepository weatherRepository, CityCatalogEntityMapper mapper) {
        super(executorScheduler, observerScheduler);
        mWeatherRepository = weatherRepository;
        mMapper = mapper;
    }

    @Override
    public Completable buildUseCaseObservable(CityModel city) {
        city.setCityTitle(city.getCityTitle().trim());
        if (!isCityCorrect(city))
            return Completable.error(new CityValidationError());
        return mWeatherRepository.insertCity(mMapper.toEntity(city));
    }

    private boolean isCityCorrect(CityModel city) {
        String value = city.getCityTitle();
        return !city.getCityTitle().isEmpty();
    }

}
