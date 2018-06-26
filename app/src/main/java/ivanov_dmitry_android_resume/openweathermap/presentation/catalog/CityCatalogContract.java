package ivanov_dmitry_android_resume.openweathermap.presentation.catalog;

import java.util.List;

import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;
import ivanov_dmitry_android_resume.openweathermap.presentation.BasePresenter;
import ivanov_dmitry_android_resume.openweathermap.presentation.BaseView;

public interface CityCatalogContract {

    interface View extends BaseView {

        void showCity(List<CityModel> cities);

        void showAddingViewCity();

        void showUpdateMessage();

        void showDetailWeatherView(String serializedCity);
    }

    interface Presenter extends BasePresenter {

        void addMenuButtonClicked();

        void cityAdded();

        void cityClicked(CityModel city);
    }

}
