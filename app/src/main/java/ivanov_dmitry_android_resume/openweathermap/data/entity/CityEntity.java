
package ivanov_dmitry_android_resume.openweathermap.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityEntity {

    @SerializedName("id")
    @Expose
    private Double id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coord")
    @Expose
    private CoordEntity coord;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private Double population;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordEntity getCoord() {
        return coord;
    }

    public void setCoord(CoordEntity coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

}
