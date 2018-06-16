package com.example.android.abndmyjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare array list for music genres
        // todo - allow users to add custom music categories
        ArrayList<String> genres = new ArrayList<>();

        // populate array list
        genres.add(getString(R.string.folk));
        genres.add(getString(R.string.hiphop_rap));
        genres.add(getString(R.string.island_music));
        genres.add(getString(R.string.oldies));

        // associate adapter to the view
        ArrayAdapter<String> genresAdapter =
                new ArrayAdapter<>(this, R.layout.genre_list,genres);

        GridView genreGrid = findViewById(R.id.grid);

        genreGrid.setAdapter(genresAdapter);

        /* set a click listener to each item in the grid and use Intent to
         * launch the respective activity*/
        genreGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position) {
                    case 0:
                        Intent openFolk = new Intent(MainActivity.this, FolkRock.class);
                        startActivity(openFolk);
                        break;
                    case 1:
                        Intent openHipHop = new Intent(MainActivity.this, HipHopRap.class);
                        startActivity(openHipHop);
                        break;
                    case 2:
                        Intent openIsland = new Intent(MainActivity.this, IslandMusic.class);
                        startActivity(openIsland);
                        break;
                    case 3:
                        Intent openOldies = new Intent(MainActivity.this, Oldies.class);
                        startActivity(openOldies);
                        break;
                }
            }
        });


    }

}
