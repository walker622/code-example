package ivanov_dmitry_android_resume.openweathermap.presentation.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import ivanov_dmitry_android_resume.openweathermap.presentation.add_new_city.EditCityActivity;
import ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail.WeatherDetailActivity;

public class Navigator {

    public void openEditCityActivity(Activity activity, int requestCode, Bundle bundle) {
        Intent intent = new Intent(activity, EditCityActivity.class);
        if (bundle != null)
            intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestCode);
    }

    public void openWeatherDetailActivity(Activity activity, int requestCode, Bundle bundle) {
        Intent intent = new Intent(activity, WeatherDetailActivity.class);
        if (bundle != null)
            intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestCode);
    }

}
