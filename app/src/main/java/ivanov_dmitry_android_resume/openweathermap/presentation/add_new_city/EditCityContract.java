package ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city;

import ivanov_dmitry_android_resume.openweathermap.presentation.BasePresenter;
import ivanov_dmitry_android_resume.openweathermap.presentation.BaseView;

public interface EditCityContract {

    interface View extends BaseView {
        void showError();

        void complete();
    }

    interface Presenter extends BasePresenter {
        void onCitySaveClicked(String value);
    }

}
