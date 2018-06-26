package ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city;

import io.reactivex.observers.DisposableCompletableObserver;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.AddCity;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.GetCityCatalog;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.error.CityValidationError;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;

public class EditCityPresenter implements EditCityContract.Presenter {
    private EditCityContract.View view;
    private GetCityCatalog getCityCatalogUseCase;
    private AddCity addCityUseCase;

    public EditCityPresenter(EditCityContract.View view, GetCityCatalog getCityCatalog, AddCity addCity) {
        this.view = view;
        this.getCityCatalogUseCase = getCityCatalog;
        this.addCityUseCase = addCity;
    }

    @Override
    public void take() {
    }

    @Override
    public void drop() {
        getCityCatalogUseCase.dispose();
        addCityUseCase.dispose();
        view = null;
    }

    @Override
    public void onCitySaveClicked(String value) {
        CityModel city = new CityModel(value);
        addCityUseCase.execute(new InsertObserver(), city);
    }

    class InsertObserver extends DisposableCompletableObserver {
        @Override
        public void onComplete() {
            view.complete();
        }

        @Override
        public void onError(Throwable e) {
            try {
                throw e;
            } catch (CityValidationError er) {
                view.showError();
            } catch (Throwable er) {
                er.printStackTrace();
            }
        }
    }

}
