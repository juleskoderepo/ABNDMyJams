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

        ArrayList<String> genres = new ArrayList<String>();

        genres.add(getString(R.string.folk_indie));
        genres.add(getString(R.string.hiphop_rap));
        genres.add(getString(R.string.island_music));
        genres.add(getString(R.string.oldies));

        ArrayAdapter<String> genresAdapter =
                new ArrayAdapter<String>(this, R.layout.list_item,genres);

        GridView genreGrid = (GridView) findViewById(R.id.grid);

        genreGrid.setAdapter(genresAdapter);

        genreGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int p = position;

                switch(p) {
                    case 0:
                        Intent openFolk = new Intent(MainActivity.this, FolkIndieRock.class);
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
