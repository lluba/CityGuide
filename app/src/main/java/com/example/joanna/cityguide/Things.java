package com.example.joanna.cityguide;

public class Things {

    /**
     * {@link Things} represents all the info about songs.
     * It contains a song title, Artist and time of song .

     /** Song Title*/
    private String mThings;

    /** Image resource ID for the word */
    private int mImageResourceId;

    /**
     * Create a new Song object.
     */
    public Things(String Things, int ImageResourceId) {
        mThings = Things;
        mImageResourceId = ImageResourceId;
    }
    /**
     * Get song title.
     */
    public String getThings() {
        return mThings;
    }
    /**
     * Get Artist name.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
    }
