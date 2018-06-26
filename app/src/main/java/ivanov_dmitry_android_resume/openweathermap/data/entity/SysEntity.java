
package ivanov_dmitry_android_resume.openweathermap.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SysEntity {

    @SerializedName("pod")
    @Expose
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

}
