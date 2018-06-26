package ivanov_dmitry_android_resume.openweathermap.domain.model;

public class CityModel {
    private String cityTitle;

    public CityModel(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }
}
