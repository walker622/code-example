
package ivanov_dmitry_android_resume.openweathermap.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListEntity {

    @SerializedName("dt")
    @Expose
    private Double dt;
    @SerializedName("main")
    @Expose
    private MainEntity main;
    @SerializedName("weather")
    @Expose
    private java.util.List<WeatherEntity> weather = null;
    @SerializedName("clouds")
    @Expose
    private CloudsEntity clouds;
    @SerializedName("wind")
    @Expose
    private WindEntity wind;
    @SerializedName("sys")
    @Expose
    private SysEntity sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    public Double getDt() {
        return dt;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public MainEntity getMain() {
        return main;
    }

    public void setMain(MainEntity main) {
        this.main = main;
    }

    public java.util.List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<WeatherEntity> weather) {
        this.weather = weather;
    }

    public CloudsEntity getClouds() {
        return clouds;
    }

    public void setClouds(CloudsEntity clouds) {
        this.clouds = clouds;
    }

    public WindEntity getWind() {
        return wind;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    public SysEntity getSys() {
        return sys;
    }

    public void setSys(SysEntity sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}
