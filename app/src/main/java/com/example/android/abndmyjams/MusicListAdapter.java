package com.example.android.abndmyjams;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicListAdapter extends ArrayAdapter<Music>{

        /**
         *  Custom constructor for a new MusicListAdapter object.
         *  The context is used to inflate the layout file and the list is the data we want to populate
         *  into the lists.
         *
         * @param context Current context used to inflate the layout file.
         * @param music A list of Music objects to display in a list/view.
         */
        public MusicListAdapter(Activity context, ArrayList<Music> music){

            super(context, 0, music);
        }

        /**
         * Provides a view for an AdpaterView (ListView, GridView, etc.)
         *
         * @param position The index in the list of data that should be displayed in the list item view
         * @param convertView The recycled view to pupulate.
         * @param parent The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item,parent,false);
            }

            // Get the {@link Music} object located at this position in the list
            Music currentItem = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID artist_tv
            TextView artistTV = listItemView.findViewById(R.id.artist_tv);
            // Get the artist name from the current Music object and set this text
            // on the artist TextView
            artistTV.setText(currentItem.getArtist());

            // Find the TextView in the list_item.xml layout with the ID song_tv
            TextView songTV = listItemView.findViewById(R.id.song_tv);
            // Get the song title from the current Music object and set this text
            // on the song TextView
            songTV.setText(currentItem.getSongTitle());

            // Find the TextView in the list_item.xml layout with the ID album_tv
            TextView albumTV = listItemView.findViewById(R.id.album_tv);
            // Get the album title from the current Music object and set this text
            // on the album TextView
            albumTV.setText(currentItem.getAlbum());

            // Find the TextView in the list_item.xml layout with the ID genre_tv
            TextView genreTV = listItemView.findViewById(R.id.genre_tv);
            // Get the music genre from the current Music object and set this text
            // on the genre TextView
            genreTV.setText(currentItem.getMusicGenre());

            // Return the whole list item layout (with 2 TextViews) so that it can
            // be displayed in the ListView
            return listItemView;
        }
}
