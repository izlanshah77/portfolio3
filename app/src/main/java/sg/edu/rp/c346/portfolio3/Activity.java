package sg.edu.rp.c346.portfolio3;

public class Activity {

    private String type, date, time, distance;


    public Activity(String type, String date, String distance, String time) {
        this.type = type;
        this.date = date;
        this.distance = distance;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getCals(){
        Double cals = 0.0;
        if(type == "Running"){
            cals = 13.2 * Double.parseDouble(time);
        }else if(type == "Swimming"){
            cals = 8.43 * Double.parseDouble(time);
        }else if(type == "Walking"){
            cals = 7.6 * Double.parseDouble(time);
        }else if(type == "Cycling"){
            cals = 10.8 * Double.parseDouble(time);
        }

        return cals;
    }
}
