package ivanov_dmitry_android_resume.openweathermap.domain.model;

public class DayForecastModel {
    private String date;
    private double temp;
    private double max_temp;
    private double min_temp;
    private double win_speed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getWin_speed() {
        return win_speed;
    }

    public void setWin_speed(double win_speed) {
        this.win_speed = win_speed;
    }
}
