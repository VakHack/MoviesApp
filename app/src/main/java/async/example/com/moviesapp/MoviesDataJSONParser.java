package async.example.com.moviesapp;

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

                JSONObject obj = arr.getJSONObject(i);
                MovieData data = new MovieData(obj.getString("name"), obj.getString("picURL"),obj.getInt("year"));

                moviesList.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return moviesList;
    }
}
