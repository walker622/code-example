package ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ActivityScope;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.AddCity;
import ivanov_dmitry_android_resume.openweathermap.domain.interactor.catalog.GetCityCatalog;

@Module
public abstract class EditCityModule {

    @ActivityScope
    @Binds
    public abstract EditCityContract.View provideView(EditCityActivity catalogActivity);

    @ActivityScope
    @Provides
    static EditCityContract.Presenter providePresenter(EditCityContract.View view, GetCityCatalog getCityCatalog, AddCity addCity) {
        return new EditCityPresenter(view, getCityCatalog, addCity);
    }

}
