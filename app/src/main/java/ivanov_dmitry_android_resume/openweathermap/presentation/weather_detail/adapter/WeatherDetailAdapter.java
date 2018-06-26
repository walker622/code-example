package ivanov_dmitry_android_resume.openweathermap.presentation.weather_detail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ivanov_dmitry_android_resume.openweathermap.R;
import ivanov_dmitry_android_resume.openweathermap.domain.model.DayForecastModel;

public class WeatherDetailAdapter extends RecyclerView.Adapter<WeatherDetailAdapter.ViewHolder> {
    private Context mContext;
    private List<DayForecastModel> mList;

    public WeatherDetailAdapter(Context context, List<DayForecastModel> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.forecast_detail_adapter_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DayForecastModel dayForecastModel = mList.get(position);
        holder.forecastDateTextView.setText(dayForecastModel.getDate());
        holder.forecastTempTextView.setText(String.valueOf(dayForecastModel.getTemp()));
        holder.forecastTempMaxTextView.setText(String.valueOf(dayForecastModel.getMax_temp()));
        holder.forecastTempMinTextView.setText(String.valueOf(dayForecastModel.getMin_temp()));
        holder.forecastWindSpeedTextView.setText(String.valueOf(dayForecastModel.getWin_speed()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.forecast_date)
        TextView forecastDateTextView;
        @BindView(R.id.forecast_temp)
        TextView forecastTempTextView;
        @BindView(R.id.forecast_temp_max)
        TextView forecastTempMaxTextView;
        @BindView(R.id.forecast_temp_min)
        TextView forecastTempMinTextView;
        @BindView(R.id.forecast_wind_speed)
        TextView forecastWindSpeedTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
