package com.example.android.abndmyjams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FolkRock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // declare an array list of music
        ArrayList<Music> folkList = new ArrayList<Music>();

        // populate the array list
        folkList.add(new Music ("Bob Schneider","40 Dogs (Like Romeo and Juliet)","Lovely Creatures",getString(R.string.folk)));
        folkList.add(new Music ("Bob Schneider","Big Blue Sea", "Lonelyland", getString(R.string.folk)));
        folkList.add(new Music ("Ray LaMontange","You Are The Best Thing","Gossip in the Grain",getString(R.string.folk)));
        folkList.add(new Music ("Ray LaMontange","Let It Be Me","Gossip in the Grain",getString(R.string.folk)));
        folkList.add(new Music ("Ray LaMontange","Trouble","Trouble",getString(R.string.folk)));
        folkList.add(new Music ("Jack Johnson","Banana Pancakes","In Between Dreams", getString(R.string.folk)));
        folkList.add(new Music ("Jack Johnson","Flake","Brushfire Fairytales", getString(R.string.folk)));
        folkList.add(new Music ("The Lumineers","Ho Hey","The Lumineers", getString(R.string.folk)));
        folkList.add(new Music ("The Lumnieers","Falling","", getString(R.string.folk)));
        folkList.add(new Music ("Mumford & Sons","I Will Wait","Babel", getString(R.string.folk)));

        // associate the MusicListAdapter to the ListView
        MusicListAdapter adapter = new MusicListAdapter(this,folkList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);



    }
}