package async.example.com.moviesapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 25/11/2017.
 */

public class MoviesDataJSONParser {

    public static ArrayList<MovieData> parseJSON(String json){

        ArrayList<MovieData> moviesList = new ArrayList<>();

        try {

            JSONArray arr = new JSONArray(json);

            for(int i = 0; i < arr.length(); ++i){

                JSONObject moviesObj = arr.getJSONObject(i);
                MovieData data = new MovieData(moviesObj.getString("name"), moviesObj.getString("picURL"), Integer.valueOf(moviesObj.getString("year")));

                moviesList.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return moviesList;
    }
}
