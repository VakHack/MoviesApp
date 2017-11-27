package async.example.com.moviesapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    List<MovieData> movies;
    DataItemAdapter adapter;

    final String jsonURL = "http://freetexthost.in/paste.php?raw&id=162010";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONURLReader reader = new JSONURLReader(jsonURL);
        try {
            movies = MoviesDataJSONParser.parseJSON(reader.execute().get(1000, TimeUnit.MILLISECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        TextView title = findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "Anabelle Script.ttf"));

        SearchView searchView = findViewById(R.id.searchBar);
        searchView.setQueryHint("Insert name");

        //setting recycler view
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvItems);

        adapter = new DataItemAdapter(movies, this);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.setMovies(ByNameMoviesFinder.find(movies, query));

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.setMovies(ByNameMoviesFinder.find(movies, newText));

                return false;
            }
        });
    }
}
