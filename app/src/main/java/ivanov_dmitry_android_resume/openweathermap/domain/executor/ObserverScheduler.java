package ivanov_dmitry_android_resume.openweathermap.domain.executor;

import io.reactivex.Scheduler;

public interface ObserverScheduler {
    Scheduler getObserverScheduler();
}
