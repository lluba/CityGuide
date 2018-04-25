package com.example.joanna.cityguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Joanna on 20.04.2018.
 */


public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Restaurants();
        } else if (position == 1) {
            return new PlacesToSee();
        } else if (position == 2) {
            return new PublicTransportation();
        } else
            return new EventsCalendar();

    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.restaurants);
        } else if (position == 1) {
            return mContext.getString(R.string.places_to_see);
        }
     else if (position == 2) {
        return mContext.getString(R.string.public_transportation);
    }
        else
            return mContext.getString(R.string.events_calendar);
    }

}

