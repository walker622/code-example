package ivanov_dmitry_android_resume.openweathermap.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;

public abstract class CompletableUseCase<Params> {
    private ExecutorScheduler mExecutorScheduler;
    private ObserverScheduler mObserverScheduler;
    private CompositeDisposable disposables;

    public CompletableUseCase(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler) {
        this.mExecutorScheduler = executorScheduler;
        this.mObserverScheduler = observerScheduler;
        this.disposables = new CompositeDisposable();
    }

    public abstract Completable buildUseCaseObservable(Params params);

    public void execute(DisposableCompletableObserver observer, Params params) {
        final Completable observable = this.buildUseCaseObservable(params)
                .subscribeOn(mExecutorScheduler.getExecutorScheduler())
                .observeOn(mObserverScheduler.getObserverScheduler());
        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!disposables.isDisposed())
            disposables.dispose();
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
