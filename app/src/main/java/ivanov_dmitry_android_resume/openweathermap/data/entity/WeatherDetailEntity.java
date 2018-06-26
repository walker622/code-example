
package ivanov_dmitry_android_resume.openweathermap.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDetailEntity {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Double cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<ListEntity> list = null;
    @SerializedName("city")
    @Expose
    private CityEntity city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public java.util.List<ListEntity> getList() {
        return list;
    }

    public void setList(java.util.List<ListEntity> list) {
        this.list = list;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

}
