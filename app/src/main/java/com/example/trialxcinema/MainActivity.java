package com.example.trialxcinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    RecyclerView recView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            Toast.makeText(getApplicationContext(), "Refresh Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();

        /*  ***Now Adding Listeners on Menu Items*** */

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.most_popular:
                        Toast.makeText(getApplicationContext(), "Most Popular clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.top_rated:
                        Toast.makeText(getApplicationContext(), "Top Rated clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.favourites:
                        Toast.makeText(getApplicationContext(), "Favourites clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                return true;
            }
        });

        recView = findViewById(R.id.recView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recView.setLayoutManager(gridLayoutManager);
        processData();


    }

    public void processData() {
        String apikey = "90787843a200cfbfd55b14b39270f6a1";
        Call<com.example.trialxcinema.Response> call = ApiController.getInstance().getApi().getData(apikey);
        Log.d("TAG", "processData: " + call.toString());

        call.enqueue(new Callback<com.example.trialxcinema.Response>() {
            @Override
            public void onResponse(Call<com.example.trialxcinema.Response> call, Response<com.example.trialxcinema.Response> response) {
                List<ResponseModel> data = response.body().getResults();
                MyAdapter adapter = new MyAdapter(data);
                recView.setAdapter(adapter);
                Log.d("TAG", "onResponse: " + response.body().results.get(0).getTitle());
            }

            @Override
            public void onFailure(Call<com.example.trialxcinema.Response> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}