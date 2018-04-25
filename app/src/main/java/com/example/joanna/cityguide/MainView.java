package com.example.joanna.cityguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * Created by Joanna on 19.04.2018.
 */
public class MainView extends Fragment {

    public MainView() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_view, container, false);

        // Create a list of activities
        final ArrayList<Things> things = new ArrayList<Things>();
        things.add(new Things("Restaurants",R.drawable.restaurants));
        things.add(new Things("Places To See",  R.drawable.activity));
        things.add(new Things("Events Calendar",  R.drawable.calendar));
        things.add(new Things("Public transportation", R.drawable.transportation));


        // Create an {@link ThingsAdapter}, whose data source is a list of {@link Things}.
        ThingsAdapter adapter = new ThingsAdapter(getActivity(), things, R.color.listMainColor);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // main_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ThingsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to go to the activity of choice
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Things} object at the given position the user clicked on
                Things ThingsList = things.get(position);

              Intent activeRestaurantIntent = new Intent(view.getContext(), Restaurants.class);
              startActivity(activeRestaurantIntent);

              Intent activePlacesToSeeIntent = new Intent(view.getContext(), PlacesToSee.class);
              startActivity(activePlacesToSeeIntent);

              Intent activePublicTransportationIntent = new Intent(view.getContext(), PublicTransportation.class);
              startActivity(activePublicTransportationIntent);

              Intent activeEventsCalendarIntent = new Intent(view.getContext(), EventsCalendar.class);
              startActivity(activeEventsCalendarIntent);



            }});
        return rootView;
    }
}