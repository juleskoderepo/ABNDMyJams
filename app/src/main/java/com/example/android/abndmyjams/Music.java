package com.example.android.abndmyjams;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Music} represents the music that the user wants to listen to.
 * It contains the name of the artist or band, a song title, the album name,
 * and a music genre/category associated with the artist.
 */

public class Music implements Parcelable {

    /** Music artist or band name*/
    private String mArtist;

    /** Song title */
    private String mSongTitle;

    /** Name of album on which the song appeared*/
    private String mAlbum;

    /** The music category under which the artist falls */
    private String mMusicGenre;

    // Constructors

    /**
     * Constructs a new Music object with an artist, song title, album, and music genre.
     *
     * @param artist name of the artist or band performing a song.
     * @param songTitle name of the song/musical piece.
     * @param album name of the album
     * @param musicGenre the musical category the song or artist falls under
     */
    Music(String artist, String songTitle, String album, String musicGenre){
        mArtist = artist;
        mSongTitle = songTitle;
        mAlbum = album;
        mMusicGenre = musicGenre;

    }

    /** Parcelable interface requires non-null static field CREATOR to
    /*  generate instances of custom Parcelable class from a Parcel.*/
    public static final Parcelable.Creator<Music> CREATOR
            = new Parcelable.Creator<Music>(){
        public Music createFromParcel(Parcel in){
            return new Music(in);
        }

        public Music[] newArray(int size){
            return new Music[size];
        }
    };

    private Music(Parcel in){
        mArtist = in.readString();
        mSongTitle = in.readString();
        mAlbum = in.readString();
        mMusicGenre = in.readString();
    }


    //Methods

    /**
     * Gets the artist or band name.
     * @return the artist or band name to display
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Gets the song title.
     * @return the song title to display.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Gets the name of the album that the song appears on.
     * @return the song title to display.
     */
    public String getAlbum() {
        return mAlbum;
    }

    /**
     * Gets the musical genre associated with the artist or song.
     * @return the music genre to display.
     */
    public String getMusicGenre() {
        return mMusicGenre;
    }

    // Public methods for Parcelable interface

    @Override
    public int describeContents() {
        return 0;
    }

    // Flattens Music object into a Parcel.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mArtist);
        dest.writeString(mSongTitle);
        dest.writeString(mAlbum);
        dest.writeString(mMusicGenre);
    }
}
