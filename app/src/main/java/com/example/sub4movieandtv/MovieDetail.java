package com.example.sub4movieandtv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvDateReleased, tvOverview, tvBudget,
            tvRevenue, tvUserScore, tvRuntime, tvLanguage, tvStatus, tvGenre;

    ImageView imagePoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        tvTitle = findViewById(R.id.tv_item_title);
        tvStatus = findViewById(R.id.tv_status_popularity);
        tvUserScore = findViewById(R.id.tv_item_userScore);
        tvBudget = findViewById(R.id.tv_item_budget);
        tvOverview = findViewById(R.id.tv_item_overview);
        tvDateReleased = findViewById(R.id.tv_item_dateReleased);
        tvLanguage = findViewById(R.id.tv_item_language);
        tvRuntime = findViewById(R.id.tv_vote_count);
        imagePoster = findViewById(R.id.poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getName());
        tvStatus.setText(movie.getReleaseDate());
        tvUserScore.setText(movie.getUser_score().toString());
        tvBudget.setText(movie.getPopularity());
        tvOverview.setText(movie.getOverview());
        tvDateReleased.setText(movie.getReleaseDate());
        tvLanguage.setText(movie.getLanguage());
        tvRuntime.setText(movie.getVoteCount());
        //tvGenre.setText(movie.getGenre());

        String urlImg = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
        Glide.with(this)
                .load(urlImg + movie.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(imagePoster);
    }
}
