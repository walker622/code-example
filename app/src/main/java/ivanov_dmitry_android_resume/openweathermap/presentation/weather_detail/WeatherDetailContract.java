package ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail;

import android.os.Bundle;

import java.util.List;

import ivanov_dmitry_android_resume.openweathermap.domain.model.DayForecastModel;
import ivanov_dmitry_android_resume.openweathermap.presentation.BasePresenter;
import ivanov_dmitry_android_resume.openweathermap.presentation.BaseView;

public interface WeatherDetailContract {

    interface View extends BaseView {
        Bundle getBundle();

        void showError(String message);

        void showForecast(List<DayForecastModel> list);
    }

    interface Presenter extends BasePresenter {

    }

}
