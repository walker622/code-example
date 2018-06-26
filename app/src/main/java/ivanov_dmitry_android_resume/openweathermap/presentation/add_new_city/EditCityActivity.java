package ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city;

import android.os.Bundle;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;
import ivanov_dmitry_android_resume.openweathermap.R;

public class EditCityActivity extends DaggerAppCompatActivity implements EditCityContract.View {
    @Inject
    EditCityContract.Presenter mPresenter;
    @BindView(R.id.city_title_edit)
    EditText mCityTitleEditText;

    public static int RESULT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_city_view);
        ButterKnife.bind(this);
        mPresenter.take();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.drop();
    }

    @OnClick(R.id.city_edit_save)
    public void onCitySaveClicked() {
        mPresenter.onCitySaveClicked(mCityTitleEditText.getText().toString());
    }

    @Override
    public void showError() {
        mCityTitleEditText.setError(getString(R.string.city_validation_error));
    }

    @Override
    public void complete() {
        setResult(RESULT_CODE);
        finish();
    }
}
