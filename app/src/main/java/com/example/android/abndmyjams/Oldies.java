package com.example.android.abndmyjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Oldies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // declare an array list of music
        final ArrayList<Music> oldiesList = new ArrayList<>();

        // populate the array list
        oldiesList.add(new Music ("Aretha Franklin","Respect","I Never Loved a Man the Way I Love You", getString(R.string.oldies)));
        oldiesList.add(new Music ("The Beach Boys","Good Vibrations","Good Vibrations", getString(R.string.oldies)));
        oldiesList.add(new Music ("Bobby Hebb","Sunny","Sunny", getString(R.string.oldies)));
        oldiesList.add(new Music ("The Drifters","Under the Boardwalk","Under the Boardwalk",getString(R.string.oldies)));
        oldiesList.add(new Music ("The Four Seasons","December, 1963 (Oh What a Night)","Who Loves You",getString(R.string.oldies)));
        oldiesList.add(new Music ("The Temptations","My Girl","The Temptations Sing Smokey", getString(R.string.oldies)));
        oldiesList.add(new Music ("Jackie Wilson","Higher and Higher", "I'm the One to Do It", getString(R.string.oldies)));
        oldiesList.add(new Music ("The Jackson 5","I Want You Back","Diana Ross Presents The Jackson 5",getString(R.string.oldies)));
        oldiesList.add(new Music ("Marvin Gaye & Tammi Terrell","Ain't No Mountain High Enough","United", getString(R.string.oldies)));
        oldiesList.add(new Music ("Otis Redding","The Dock of the Bay","The Dock of the Bay",getString(R.string.oldies)));


        // associate the MusicListAdapter to the ListView
        MusicListAdapter adapter = new MusicListAdapter(this,oldiesList);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        // launch the play activity to play the selected item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music currentTrack = oldiesList.get(position);
                Intent openPlayer = new Intent(Oldies.this,Player.class);
                openPlayer.putExtra("track",currentTrack);
                openPlayer.putExtra("list",oldiesList);
                startActivity(openPlayer);
            }
        });

    }
}
