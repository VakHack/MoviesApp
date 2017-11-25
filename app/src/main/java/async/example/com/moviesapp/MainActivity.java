package async.example.com.moviesapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MovieData> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = MoviesDataJSONParser.parseJSON(JSONFileToStringConvertor.convert(this, R.raw.movies));

        TextView title = findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "Anabelle Script.ttf"));

        //setting recycler view
        DataItemAdapter adapter = new DataItemAdapter(movies, this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }
}
