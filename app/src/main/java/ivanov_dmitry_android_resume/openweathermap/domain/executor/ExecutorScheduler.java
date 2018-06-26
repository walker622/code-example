package ivanov_dmitry_android_resume.openweathermap.domain.executor;

import java.util.concurrent.Executor;

import io.reactivex.Scheduler;

public interface ExecutorScheduler {
    Scheduler getExecutorScheduler();
}
