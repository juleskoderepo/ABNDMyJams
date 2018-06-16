package com.example.android.abndmyjams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Player extends AppCompatActivity {
    Button playButton;
    CharSequence playButtonText;
    int playButtonTextColor;
    boolean is_playing;
    boolean is_playing_value;

    // define String constants for Bundle keys
    public static final String KEY_savedPlayButtonText = "savedPlayButtonText";
    public static final String KEY_savedPlayButtonTextColor = "savedPlayButtonTextColor";
    public static final String KEY_savedIsPlayingState = "savedIsPlayingState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playButton = findViewById(R.id.play_button);
        is_playing = true;

        // find text views in player and assign to variables
        TextView songTitle_TV = findViewById(R.id.player_track_tv);
        TextView artist_TV = findViewById(R.id.player_artist_tv);
        TextView album_TV = findViewById(R.id.player_album_tv);

        /* get the data from the parcel passed in the Intent and
         * assign to the Music object 'track'.  */
        Music track = getIntent().getParcelableExtra("track");

        /* get the individual elements from 'track' and set the text
         * on the corresponding text view in the player. */
        songTitle_TV.setText(track.getSongTitle());
        artist_TV.setText(track.getArtist());
        album_TV.setText(track.getAlbum());

        /* find the play/pause button in the player and set text to 'Pause'.
         * assume playback has started on opening the player */
        playButton.setFocusable(true);
        playButton.setFocusableInTouchMode(true);
        playButton.requestFocus();
        playButton.setText(getString(R.string.pause));

        // handle click events for the play/pause button.
        // set the click listener on the play/pause button.
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (is_playing){
                    /* display 'Pause' as the button text when the track is playing and the
                     * button is clicked. */
                    playButton.setText(getString(R.string.play));
                    is_playing = false; // update is_playing to false.

                    // display toast message to user that playback has been paused.
                    Toast.makeText(getApplicationContext(),getString(R.string.on_pause),Toast.LENGTH_LONG).show();
                } else {
                    /* display 'Play' as the button text when the track is paused and the
                     *  button is clicked. */
                    playButton.setText(getString(R.string.pause));
                    is_playing = true; // update is_playing to true.

                    // display toast message to user that playback is in progress.
                    Toast.makeText(getApplicationContext(),getString(R.string.on_play),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        // save transient states
        playButtonText = playButton.getText();
        playButtonTextColor = playButton.getCurrentTextColor();
        is_playing_value = is_playing;

        // add saved values to bundle
        savedInstanceState.putCharSequence(KEY_savedPlayButtonText,playButtonText);
        savedInstanceState.putInt(KEY_savedPlayButtonTextColor,playButtonTextColor);
        savedInstanceState.putBoolean(KEY_savedIsPlayingState,is_playing_value);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // retrieve saved values
        playButtonText = savedInstanceState.getCharSequence(KEY_savedPlayButtonText);
        playButtonTextColor = savedInstanceState.getInt(KEY_savedPlayButtonTextColor);
        is_playing_value = savedInstanceState.getBoolean(KEY_savedIsPlayingState);

        // restore saved values
        playButton.setText(playButtonText);
        playButton.setTextColor(playButtonTextColor);
        is_playing = is_playing_value;
    }
}
