package com.example.android.abndmyjams;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class IslandMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // declare an array list of music
        final ArrayList<Music> islandMusicList = new ArrayList<>();

        // populate the array list
        islandMusicList.add(new Music ("Anuhea","Simple Love Song","For Love", getString(R.string.island_music)));
        islandMusicList.add(new Music ("Bob Marley and the Wailers","Three Little Birds","Exodus", getString(R.string.island_music)));
        islandMusicList.add(new Music ("Common Kings","No Other Love","Summer Anthems",getString(R.string.island_music)));
        islandMusicList.add(new Music ("Fiji","Sweet Darlin'","Born & Raised",getString(R.string.island_music)));
        islandMusicList.add(new Music ("J Boog","Sunshine Girl","Backyard Boogie",getString(R.string.island_music)));
        islandMusicList.add(new Music ("Ka'au Crater Boys","Surf","The Best of Ka'au Crater Boys", getString(R.string.island_music)));
        islandMusicList.add(new Music ("Kimie Minor feat. Imua Garza","Make Me Say","To The Sea", getString(R.string.island_music)));
        islandMusicList.add(new Music ("Jasmine Lee","Last First Kiss", "Last First Kiss", getString(R.string.island_music)));
        islandMusicList.add(new Music ("Sean Na'auao","Drop Baby Drop","Homegrown Hawaiian",getString(R.string.island_music)));
        islandMusicList.add(new Music ("Tenelle","Tell Me","Tell Me", getString(R.string.island_music)));

        // associate the MusicListAdapter to the ListView
        MusicListAdapter adapter = new MusicListAdapter(this,islandMusicList);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        // launch the play activity to play the selected item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music currentTrack = islandMusicList.get(position);
                Intent openPlayer = new Intent(IslandMusic.this,Player.class);
                openPlayer.putExtra("track",currentTrack);
                openPlayer.putExtra("list",islandMusicList);
                startActivity(openPlayer);
            }
        });

    }
}
