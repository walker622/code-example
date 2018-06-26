package ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail;

import com.google.gson.Gson;

import io.reactivex.observers.DisposableSingleObserver;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.weather_detail.GetWeekForecast;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;
import ivanov_dmitry_android_resume.openweathermap.domain.model.ForecastModel;
import ivanov_dmitry_android_resume.openweathermap.presentation.catalog.CityCatalogActivity;

public class WeatherDetailPresenter implements WeatherDetailContract.Presenter {
    private WeatherDetailContract.View view;
    private GetWeekForecast getWeekForecastUseCase;

    public WeatherDetailPresenter(WeatherDetailContract.View view, GetWeekForecast getWeekForecastUseCase) {
        this.view = view;
        this.getWeekForecastUseCase = getWeekForecastUseCase;
    }

    @Override
    public void take() {
        retrieveWeatherWeekInformation();
    }

    private void retrieveWeatherWeekInformation() {
        CityModel city = new Gson().fromJson(view.getBundle().getString(CityCatalogActivity.CITY_EXTRA), CityModel.class);
        getWeekForecastUseCase.execute(new ForecastObserver(), city.getCityTitle());
    }

    @Override
    public void drop() {
        getWeekForecastUseCase.dispose();
        view = null;
    }

    private void handleForecast(ForecastModel forecastModel) {
        switch (Integer.parseInt(forecastModel.getCode())) {
            case 200:
                view.showForecast(forecastModel.getList());
                break;
            default:
                view.showError(forecastModel.getMessage());
        }
    }

    class ForecastObserver extends DisposableSingleObserver<ForecastModel> {

        @Override
        public void onSuccess(ForecastModel forecastModel) {
            handleForecast(forecastModel);
        }

        @Override
        public void onError(Throwable e) {
            try {
                throw e;
            } catch (Exception ex) {
                view.showError(ex.getMessage());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

}
