package com.example.android.abndmyjams;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Player extends AppCompatActivity {
    TextView songTitle_TV;
    TextView artist_TV;
    TextView album_TV;
    Button playButton;
    Button skipPrevButton;
    Button skipNextButton;
    String currentTrack;
    String currentArtist;
    String currentAlbum;
    boolean is_playing;


    // define String constants for Bundle keys
    public static final String KEY_savedIsPlayingState = "savedIsPlayingState";
    public static final String KEY_savedCurrentTrack = "savedCurrentTrack";
    public static final String KEY_savedCurrentArtist = "savedCurrentArtist";
    public static final String KEY_savedCurrentAlbum = "savedCurrentAlbum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playButton = findViewById(R.id.play_button);
        skipPrevButton = findViewById(R.id.skip_prev_button);
        skipNextButton = findViewById(R.id.skip_next_button);
        is_playing = true;

        // find text views in player and assign to variables
        songTitle_TV = findViewById(R.id.player_track_tv);
        artist_TV = findViewById(R.id.player_artist_tv);
        album_TV = findViewById(R.id.player_album_tv);

        /* get the music list from the parcel passed in the Intent and
         * assign to the ArrayList, songList */
        final ArrayList<Music> songList = getIntent().getParcelableArrayListExtra("list");

        /* get data for the selected track from the parcel passed in the Intent and
         * assign to the Music object, 'track'.  */
        Music track = getIntent().getParcelableExtra("track");

        /* get the individual elements from 'track' and set the text
         * on the corresponding text view in the player. */
        songTitle_TV.setText(track.getSongTitle());
        artist_TV.setText(track.getArtist());
        album_TV.setText(track.getAlbum());

        currentTrack = (String) songTitle_TV.getText(); // set the selected song as current track
        currentArtist = (String) artist_TV.getText();  // set current artist
        currentAlbum = (String) artist_TV.getText();  // set current album


        /* find the play/pause button in the player and set text to 'Pause'.
         * assume playback has started on opening the player */
        playButton.setFocusable(true);
        playButton.setFocusableInTouchMode(true);
        playButton.requestFocus();
        // show the pause symbol on the button as the music plays by default on open
        ViewCompat.setBackground(playButton,ContextCompat.getDrawable(this,R.drawable.pause_circle_outline_indigo_24dp));

        // Handle click events for the player buttons.

        // set the click listener on the play/pause button.
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (is_playing) {
                    // when the user clicks the button to pause the playback, display the play symbol
                    ViewCompat.setBackground(playButton,ContextCompat.getDrawable(Player.this,R.drawable.play_circle_outline_indigo_24dp));
                    is_playing = false; // update is_playing to false.

                    // display toast message to user that playback has been paused.
                    Toast.makeText(getApplicationContext(), getString(R.string.on_pause), Toast.LENGTH_LONG).show();
                } else {
                    // when the user clicks the button to start playback, display the pause symbol.
                    ViewCompat.setBackground(playButton,ContextCompat.getDrawable(Player.this,R.drawable.pause_circle_outline_indigo_24dp));
                    is_playing = true; // update is_playing to true.

                    // display toast message to user that playback is in progress.
                    Toast.makeText(getApplicationContext(), getString(R.string.on_play), Toast.LENGTH_LONG).show();
                }
            }
        });


        // set click listener on the skip previous button
        skipPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* loop through the music list to find the current song
                 * and (dis)play the previous song on the list.
                 */
                for (int i = 0; i < songList.size(); i++) {
                    if (i == 0 && currentTrack.equals(songList.get(i).getSongTitle())) {
                        break; // exit loop
                    } else if (currentTrack.equals(songList.get(i).getSongTitle())) {
                        songTitle_TV.setText(songList.get(i - 1).getSongTitle());
                        artist_TV.setText(songList.get(i - 1).getArtist());
                        album_TV.setText(songList.get(i - 1).getAlbum());

                        currentTrack = (String) songTitle_TV.getText();//update current track
                        currentArtist = (String) artist_TV.getText(); //update current artist
                        currentAlbum = (String) album_TV.getText(); //update current album

                        break; // exit loop
                    }
                }
            }
        });

        // set click listener on the skip next button
        skipNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* loop through the music list to find the current song
                 * and (dis)play the next song on the list.
                 */
                for (int i = 0; i < songList.size(); i++) {
                    if (i == songList.size() - 1 && currentTrack.equals(songList.get(i).getSongTitle())) {
                        break; // exit loop
                    } else if (currentTrack.equals(songList.get(i).getSongTitle())) {
                        songTitle_TV.setText(songList.get(i + 1).getSongTitle());
                        artist_TV.setText(songList.get(i + 1).getArtist());
                        album_TV.setText(songList.get(i + 1).getAlbum());

                        currentTrack = (String) songTitle_TV.getText();//update current track
                        currentArtist = (String) artist_TV.getText(); //update current artist
                        currentAlbum = (String) album_TV.getText(); //update current album


                        break; // exit loop
                    }
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // get values to save and add to bundle
        savedInstanceState.putBoolean(KEY_savedIsPlayingState, is_playing);
        savedInstanceState.putString(KEY_savedCurrentTrack, currentTrack);
        savedInstanceState.putString(KEY_savedCurrentArtist,currentArtist);
        savedInstanceState.putString(KEY_savedCurrentAlbum,currentAlbum);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // retrieve and restore saved values
        is_playing = savedInstanceState.getBoolean(KEY_savedIsPlayingState);
        currentTrack = savedInstanceState.getString(KEY_savedCurrentTrack);
        currentArtist = savedInstanceState.getString(KEY_savedCurrentArtist);
        currentAlbum = savedInstanceState.getString(KEY_savedCurrentAlbum);
        songTitle_TV.setText(currentTrack);
        artist_TV.setText(currentArtist);
        album_TV.setText(currentAlbum);

    }
}
