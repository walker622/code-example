package ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.domain.mapper.CityCatalogEntityMapper;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.SingleUseCase;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;
import ivanov_dmitry_android_resume.openweathermap.data.WeatherRepository;

public class GetCityCatalog extends SingleUseCase<List<CityModel>, Void> {
    private WeatherRepository mWeatherRepository;
    private CityCatalogEntityMapper mMapper;

    @Inject
    public GetCityCatalog(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler, WeatherRepository weatherRepository, CityCatalogEntityMapper mapper) {
        super(executorScheduler, observerScheduler);
        mWeatherRepository = weatherRepository;
        mMapper = mapper;
    }


    @Override
    public Single<List<CityModel>> buildUseCaseObservable(Void aVoid) {
        return mWeatherRepository.getCities().map(cityCatalogEntities -> {
            List<CityModel> modelList = new ArrayList<>();
            for (CityCatalogEntity entity : cityCatalogEntities)
                modelList.add(mMapper.fromEntity(entity));
            return modelList;
        });
    }
}
