package ivanov_dmitry_android_resume.openweathermap.presentation;

import com.squareup.leakcanary.LeakCanary;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ivanov_dmitry_android_resume.openweathermap.di.component.DaggerAppComponent;
import ivanov_dmitry_android_resume.openweathermap.di.module.ApplicationModule;

public class WeatherApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(new ApplicationModule(this)).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initCanary();
    }

    private void initCanary() {
        if (LeakCanary.isInAnalyzerProcess(this))
            return;
        LeakCanary.install(this);
    }
}
