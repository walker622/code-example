package ivanov_dmitry_android_resume.openweathermap.presentation.utils;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;

public class ExecuteThread implements ExecutorScheduler {
    @Override
    public Scheduler getExecutorScheduler() {
        return Schedulers.newThread();
    }
}
