package ivanov_dmitry_android_resume.openweathermap.di.component;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import ivanov_dmitry_android_resume.openweathermap.di.module.ActivityBindingModule;
import ivanov_dmitry_android_resume.openweathermap.di.module.ApplicationModule;
import ivanov_dmitry_android_resume.openweathermap.di.module.OpenWeatherMapModule;
import ivanov_dmitry_android_resume.openweathermap.di.scope.ApplicationScope;
import ivanov_dmitry_android_resume.openweathermap.presentation.WeatherApplication;

@ApplicationScope
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBindingModule.class, OpenWeatherMapModule.class})
public interface AppComponent extends AndroidInjector<WeatherApplication> {

    @Component.Builder
    interface Builder {

        AppComponent.Builder application(ApplicationModule applicationModule);

        AppComponent build();

    }

}
