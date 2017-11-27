package async.example.com.moviesapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 26/11/2017.
 */

public class ByNameMoviesFinder {

    public static List<MovieData> find(List<MovieData> moviesSource, String name){

        ArrayList<MovieData> filteredList = new ArrayList<>(moviesSource);

        if(name.equals("")){

            return filteredList;
        }

        for(int i = 0; i < filteredList.size(); ++i){

            if(!filteredList.get(i).getName().contains(name)){

                filteredList.remove(i);
            }
        }

        return filteredList;
    }
}
