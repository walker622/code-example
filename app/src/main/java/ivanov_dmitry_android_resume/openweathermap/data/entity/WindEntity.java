
package ivanov_dmitry_android_resume.openweathermap.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindEntity {

    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Double deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

}
