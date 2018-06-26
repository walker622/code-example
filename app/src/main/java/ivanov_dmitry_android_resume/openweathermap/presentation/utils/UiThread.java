package ivanov_dmitry_android_resume.openweathermap.presentation.utils;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;

public class UiThread implements ObserverScheduler {
    @Override
    public Scheduler getObserverScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
