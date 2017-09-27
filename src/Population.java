/**
 * Created by hari on 25/09/17.
 */
public class Population {


    /* POJO */
    long state_code;
    long district_code;
    long sub_district_code;
    String level;
    String area_name;
    long noofvillages;
    long total_population;
    long male_population;
    long female_population;



    //getters

    public long getState_code() {
        return state_code;
    }

    public long getDistrict_code() {
        return district_code;
    }

    public long getSub_district_code() {
        return sub_district_code;
    }

    public String getLevel() {
        return level;
    }

    public String getArea_name() {
        return area_name;
    }

    public long getNoofvillages() {
        return noofvillages;
    }

    public long getTotal_population() {
        return total_population;
    }

    public long getMale_population() {
        return male_population;
    }

    public long getFemale_population() {
        return female_population;
    }

    //setters

    public void setState_code(long state_code) {
        this.state_code = state_code;
    }

    public void setDistrict_code(long district_code) {
        this.district_code = district_code;
    }

    public void setSub_district_code(long sub_district_code) {
        this.sub_district_code = sub_district_code;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public void setNoofvillages(long noofvillages) {
        this.noofvillages = noofvillages;
    }

    public void setTotal_population(long total_population) {
        this.total_population = total_population;
    }

    public void setMale_population(long male_population) {
        this.male_population = male_population;
    }

    public void setFemale_population(long female_population) {
        this.female_population = female_population;
    }

    @Override
    public String toString() {
        return "Population{" +
                "state_code=" + state_code +
                ", district_code=" + district_code +
                ", sub_district_code=" + sub_district_code +
                ", level='" + level + '\'' +
                ", area_name='" + area_name + '\'' +
                ", noofvillages=" + noofvillages +
                ", total_population=" + total_population +
                ", male_population=" + male_population +
                ", female_population=" + female_population +
                '}';
    }
}
