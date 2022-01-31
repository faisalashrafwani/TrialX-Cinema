package com.example.trialxcinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class Movie extends AppCompatActivity {
    Toolbar toolbarMovie;
    ImageView img, rndImg;
    FloatingActionButton favBtn;
    TextView title_, rating_, releaseDate_, overview_, overview_1, overview_2, overview_3, overview_4;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        toolbarMovie = findViewById(R.id.toolbarMovie);
        img = findViewById(R.id.thumb_img);
        favBtn = findViewById(R.id.fav);
        title_ = findViewById(R.id.title);
        rndImg = findViewById(R.id.thumb_img2);
        rating_ = findViewById(R.id.rating);
        releaseDate_ = findViewById(R.id.release_date);
        overview_ = findViewById(R.id.overview);
        overview_1 = findViewById(R.id.overview1);
        overview_2 = findViewById(R.id.overview2);
        overview_3 = findViewById(R.id.overview3);
        overview_4 = findViewById(R.id.overview4);

        setSupportActionBar(toolbarMovie);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String rating = intent.getStringExtra("vote_average");
        String releaseDate = intent.getStringExtra("release_date");
        String overview = intent.getStringExtra("overview");
        String backdropPath = intent.getStringExtra("backdrop_path");

        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w780/" + backdropPath)
                .into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Play.class);
                startActivity(intent1);

            }
        });
        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w780/" + backdropPath)
                .into(rndImg);
        title_.setText(title);
        rating_.setText("    " + rating);
        releaseDate_.setText(releaseDate);
        overview_.setText(overview);
        overview_1.setText(overview);
        overview_2.setText(overview);
        overview_3.setText(overview);
        overview_4.setText(overview);

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add to Favourties Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}