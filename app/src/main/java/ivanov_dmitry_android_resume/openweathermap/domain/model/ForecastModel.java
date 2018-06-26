package ivanov_dmitry_android_resume.openweathermap.domain.model;

import java.util.List;

public class ForecastModel {
    private String code;
    private String message;
    private List<DayForecastModel> mList;

    public List<DayForecastModel> getList() {
        return mList;
    }

    public void setList(List<DayForecastModel> list) {
        mList = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
