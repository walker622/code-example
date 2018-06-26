package ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import ivanov_dmitry_android_resume.openweathermap.R;
import ivanov_dmitry_android_resume.openweathermap.domain.model.DayForecastModel;
import ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail.adapter.WeatherDetailAdapter;

public class WeatherDetailActivity extends DaggerAppCompatActivity implements WeatherDetailContract.View {
    @Inject
    WeatherDetailContract.Presenter mPresenter;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_catalog_view);
        ButterKnife.bind(this);
        mPresenter.take();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.drop();
        if (mRecyclerView != null)
            mRecyclerView.setAdapter(null);
    }

    @Override
    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showForecast(List<DayForecastModel> list) {
        WeatherDetailAdapter adapter = new WeatherDetailAdapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}
