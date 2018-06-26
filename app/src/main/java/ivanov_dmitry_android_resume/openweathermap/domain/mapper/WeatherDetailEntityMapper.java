package ivanov_dmitry_android_resume.openweathermap.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import ivanov_dmitry_android_resume.openweathermap.data.entity.ListEntity;
import ivanov_dmitry_android_resume.openweathermap.data.entity.WeatherDetailEntity;
import ivanov_dmitry_android_resume.openweathermap.domain.model.DayForecastModel;
import ivanov_dmitry_android_resume.openweathermap.domain.model.ForecastModel;

public class WeatherDetailEntityMapper implements Mapper<WeatherDetailEntity, ForecastModel> {
    @Override
    public ForecastModel fromEntity(WeatherDetailEntity value) {
        ForecastModel model = new ForecastModel();
        model.setCode(value.getCod());
        model.setMessage(String.valueOf(value.getMessage()));
        if (value.getList() == null)
            return model;
        List<DayForecastModel> dayForecastModel = new ArrayList<>();
        for (ListEntity entity : value.getList()) {
            DayForecastModel dayForecast = new DayForecastModel();
            dayForecast.setDate(entity.getDtTxt());
            dayForecast.setTemp(entity.getMain().getTemp());
            dayForecast.setMax_temp(entity.getMain().getTempMax());
            dayForecast.setMin_temp(entity.getMain().getTempMin());
            dayForecast.setWin_speed(entity.getWind().getSpeed());
            dayForecastModel.add(dayForecast);
        }
        model.setList(dayForecastModel);
        return model;
    }

    @Override
    public WeatherDetailEntity toEntity(ForecastModel value) {
        return null;
    }
}
