package async.example.com.moviesapp;

/**
 * Created by Administrator on 25/11/2017.
 */

public class MovieData {

    private String name;
    private String picURL;
    private int year;

    public MovieData(String name, String picURL, int length) {
        this.name = name;
        this.picURL = picURL;
        this.year = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
