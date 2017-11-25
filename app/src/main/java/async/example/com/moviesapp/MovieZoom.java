package async.example.com.moviesapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieZoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_zoom);

        ImageView image = findViewById(R.id.picZoom);

        ScreenMeasurements sm = new ScreenMeasurements(this, 0);
        Picasso.with(this)
                .load(getIntent().getExtras().getString("picURL"))
                .resize(sm.getWidth(), sm.getHeight())
                .centerCrop()
                .into(image);

        TextView name = findViewById(R.id.titleZoom);
        name.setTypeface(Typeface.createFromAsset(getAssets(), "CzaristiteBold.ttf"));
        name.setText(getIntent().getExtras().getString("name"));

        TextView year = findViewById(R.id.yearZoom);
        year.setTypeface(Typeface.createFromAsset(getAssets(), "CzaristiteBold.ttf"));
        year.setText("" + getIntent().getExtras().getInt("year"));
    }
}
