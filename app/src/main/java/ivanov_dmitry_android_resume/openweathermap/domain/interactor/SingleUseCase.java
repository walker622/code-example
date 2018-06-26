package ivanov_dmitry_android_resume.openweathermap.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ExecutorScheduler;
import ivanov_dmitry_android_resume.openweathermap.domain.executor.ObserverScheduler;

public abstract class SingleUseCase<T, Params> {
    private ExecutorScheduler mExecutorScheduler;
    private ObserverScheduler mObserverScheduler;
    private CompositeDisposable disposables;

    public SingleUseCase(ExecutorScheduler executorScheduler, ObserverScheduler observerScheduler) {
        this.mExecutorScheduler = executorScheduler;
        this.mObserverScheduler = observerScheduler;
        this.disposables = new CompositeDisposable();
    }

    public abstract Single<T> buildUseCaseObservable(Params params);

    public void execute(DisposableSingleObserver<T> observer, Params params) {
        final Single<T> observable = this.buildUseCaseObservable(params)
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
