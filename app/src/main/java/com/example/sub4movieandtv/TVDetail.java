package com.example.sub4movieandtv;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class TVDetail extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";
    TextView tvTitle,tvStatus, tvGenre, tvCrew,tvUserScore,
            tvRuntime, tvLanguage, tvOverview, tvDateReleased;

    ImageView imagePoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_detail);

        tvTitle = findViewById(R.id.tv_item_title);
        tvStatus = findViewById(R.id.tv_status_popularity);
        tvUserScore = findViewById(R.id.tv_item_userScore);
        tvUserScore = findViewById(R.id.tv_item_userScore);
        tvRuntime = findViewById(R.id.tv_vote_count);
        tvLanguage = findViewById(R.id.tv_item_language);
        tvOverview = findViewById(R.id.tv_item_overview);
        tvDateReleased = findViewById(R.id.tv_item_dateReleased);
        imagePoster = findViewById(R.id.poster);

        TV tv = getIntent().getParcelableExtra(EXTRA_TV);
        tvTitle.setText(tv.getTitle());
        tvStatus.setText(tv.getPopularity());
        tvUserScore.setText(tv.getUser_score());
        tvRuntime.setText(tv.getVoteCount());
        tvLanguage.setText(tv.getOriginal_language());
        tvOverview.setText(tv.getOverview());
        tvDateReleased.setText(tv.getDate_released());

        String urlImg = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
        Glide.with(this)
                .load(urlImg + tv.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(imagePoster);
    }
}
