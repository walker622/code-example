package ivanov_dmitry_android_resume.openweathermap.presentation.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import ivanov_dmitry_android_resume.openweathermap.R;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;
import ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city.EditCityActivity;
import ivanov_dmitry_android_resume.openweathermap.presentation.catalog.adapter.CityCatalogAdapter;
import ivanov_dmitry_android_resume.openweathermap.presentation.utils.Navigator;

public class CityCatalogActivity extends DaggerAppCompatActivity implements CityCatalogContract.View, CityCatalogAdapter.OnCityCatalogClickListener {
    @Inject
    CityCatalogContract.Presenter mPresenter;
    @Inject
    Navigator mNavigator;
    @BindView(R.id.recycler)
    RecyclerView mCitiesRecyclerView;
    private CityCatalogAdapter adapter;

    public static final int EDIT_VIEW_REQUEST = 100;
    public static final String CITY_EXTRA = "CITY_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_catalog_view);
        ButterKnife.bind(this);
        mPresenter.take();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDIT_VIEW_REQUEST) {
            if (resultCode == EditCityActivity.RESULT_CODE)
                mPresenter.cityAdded();
        } else
            super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.drop();
        if (mCitiesRecyclerView != null)
            mCitiesRecyclerView.setAdapter(null);
    }

    @Override
    public void showCity(List<CityModel> cities) {
        if (adapter == null) {
            adapter = new CityCatalogAdapter(this, cities, this);
            mCitiesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            mCitiesRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mCitiesRecyclerView.setAdapter(adapter);
        } else {
            int addedPosition = cities.size() - 1;
            adapter.setCities(cities);
            adapter.notifyItemInserted(addedPosition);
            mCitiesRecyclerView.scrollToPosition(addedPosition);
        }
    }

    @Override
    public void showAddingViewCity() {
        mNavigator.openEditCityActivity(this, EDIT_VIEW_REQUEST, null);
    }

    @Override
    public void showUpdateMessage() {
        Toast.makeText(this, getString(R.string.city_success_added), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailWeatherView(String serializedCity) {
        Bundle bundle = new Bundle();
        bundle.putString(CITY_EXTRA, serializedCity);
        mNavigator.openWeatherDetailActivity(this, 0, bundle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_new_city:
                mPresenter.addMenuButtonClicked();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.city_catalog_view_menu, menu);
        return true;
    }

    @Override
    public void onCityCatalogClicked(CityModel city) {
        mPresenter.cityClicked(city);
    }
}
