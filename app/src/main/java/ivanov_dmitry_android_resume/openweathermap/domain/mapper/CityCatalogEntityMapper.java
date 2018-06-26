package ivanov_dmitry_android_resume.openweathermap.domain.mapper;

import javax.inject.Inject;

import ivanov_dmitry_android_resume.openweathermap.data.entity.CityCatalogEntity;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;

public class CityCatalogEntityMapper implements Mapper<CityCatalogEntity, CityModel> {

    @Inject
    public CityCatalogEntityMapper() {
    }

    @Override
    public CityModel fromEntity(CityCatalogEntity value) {
        return new CityModel(value.title);
    }

    @Override
    public CityCatalogEntity toEntity(CityModel value) {
        CityCatalogEntity entity = new CityCatalogEntity();
        entity.title = value.getCityTitle();
        return entity;
    }
}
