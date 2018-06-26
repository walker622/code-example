package ivanov_dmitry_android_resume.openweathermap.presentation.catalog;

import com.google.gson.Gson;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.AddCity;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.GetCityCatalog;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;

public class CityCatalogPresenter implements CityCatalogContract.Presenter {
    private GetCityCatalog getCitiesUseCase;
    private AddCity addCityUseCase;
    private CityCatalogContract.View view;

    public CityCatalogPresenter(CityCatalogContract.View view, GetCityCatalog getCitiesUseCase, AddCity addCityUseCase) {
        this.view = view;
        this.getCitiesUseCase = getCitiesUseCase;
        this.addCityUseCase = addCityUseCase;
    }

    @Override
    public void take() {
        retrieveCities();
    }

    private void retrieveCities() {
        getCitiesUseCase.execute(new CityObserver(), null);
    }

    @Override
    public void drop() {
        getCitiesUseCase.dispose();
        addCityUseCase.dispose();
        view = null;
    }

    @Override
    public void addMenuButtonClicked() {
        view.showAddingViewCity();
    }

    @Override
    public void cityAdded() {
        retrieveCities();
        view.showUpdateMessage();
    }

    @Override
    public void cityClicked(CityModel city) {
        String serializedCity = new Gson().toJson(city);
        view.showDetailWeatherView(serializedCity);
    }

    class CityObserver extends DisposableSingleObserver<List<CityModel>> {
        @Override
        public void onSuccess(List<CityModel> cities) {
            view.showCity(cities);
        }

        @Override
        public void onError(Throwable e) {
        }
    }

}
