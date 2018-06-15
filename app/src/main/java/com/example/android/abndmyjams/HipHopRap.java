package com.example.android.abndmyjams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HipHopRap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // declare an array list of music
        ArrayList<Music> folkList = new ArrayList<Music>();

        // populate the array list
        folkList.add(new Music ("Arrested Development","U","3 Years, 5 Months and 2 Days in the Life Of...", getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Beastie Boys","So What'cha Want","Check Your Head",getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Cypress Hill","The Phuncky Feel One","Cypress Hill",getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Dr. Dre","Nuthin But A G Thang","The Chronic",getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Eminem","My Name Is","The Slim Shady LP", getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Ice Cube","It Was A Good Day","The Predator", getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Jay-Z","Dirt Off Your Shoulders", "The Black Album", getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Run DMC","My Adidas","Raising Hell",getString(R.string.hiphop_rap)));
        folkList.add(new Music ("The Notorious B.I.G.","Hypnotize","Life After Death", getString(R.string.hiphop_rap)));
        folkList.add(new Music ("Tribe Called Quest","Scenario","The Low End Theory", getString(R.string.hiphop_rap)));

        // associate the MusicListAdapter to the ListView
        MusicListAdapter adapter = new MusicListAdapter(this,folkList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
