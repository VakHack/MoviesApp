package async.example.com.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 25/11/2017.
 */

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    private List<MovieData> movies;
    private Context context;

    public DataItemAdapter(List<MovieData> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {

        final MovieData data = movies.get(position);

        holder.year.setTypeface(Typeface.createFromAsset(context.getAssets(), "CzaristiteBold.ttf"));
        holder.title.setTypeface(Typeface.createFromAsset(context.getAssets(), "CzaristiteBold.ttf"));

        holder.year.setText("" + data.getYear());
        holder.title.setText(data.getName());

        ScreenMeasurements sm = new ScreenMeasurements(context, 0);
        Picasso.with(context)
                .load(data.getPicURL())
                .resize(sm.getWidth(), 300)
                .centerCrop()
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, MovieZoom.class);

                intent.putExtra("name", data.getName());
                intent.putExtra("year", data.getYear());
                intent.putExtra("picURL", data.getPicURL());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView year;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.filmName);
            year = itemView.findViewById(R.id.filmYear);
            image = itemView.findViewById(R.id.filmPic);
        }
    }
}
