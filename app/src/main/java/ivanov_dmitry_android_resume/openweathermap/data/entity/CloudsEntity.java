
package ivanov_dmitry_android_resume.openweathermap.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloudsEntity {

    @SerializedName("all")
    @Expose
    private Double all;

    public Double getAll() {
        return all;
    }

    public void setAll(Double all) {
        this.all = all;
    }

}
