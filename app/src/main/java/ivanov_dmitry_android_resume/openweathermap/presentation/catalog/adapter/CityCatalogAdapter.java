package ivanov_dmitry_android_resume.openweathermap.presentation.catalog.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ivanov_dmitry_android_resume.openweathermap.R;
import ivanov_dmitry_android_resume.openweathermap.domain.model.CityModel;

public class CityCatalogAdapter extends RecyclerView.Adapter<CityCatalogAdapter.ViewHolder> {
    private Context mContext;
    private List<CityModel> mCities;
    private OnCityCatalogClickListener mListener;

    public CityCatalogAdapter(Context context, List<CityModel> cities, OnCityCatalogClickListener listener) {
        mContext = context;
        mCities = cities;
        mListener = listener;
    }

    public void setCities(List<CityModel> cities) {
        mCities = cities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.city_catalog_adapter_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CityModel city = mCities.get(position);
        holder.cityTitleTextView.setText(city.getCityTitle());
        holder.itemHolderLinearLayout.setOnClickListener(v -> mListener.onCityCatalogClicked(city));
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView cityTitleTextView;
        @BindView(R.id.item_holder)
        LinearLayout itemHolderLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnCityCatalogClickListener {
        void onCityCatalogClicked(CityModel city);
    }

}
