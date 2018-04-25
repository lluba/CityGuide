package com.example.joanna.cityguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/* {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
        * based on a data source, which is a list of {@link Word} objects.
        */
public class ThingsAdapter extends ArrayAdapter<Things> {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link ThingsAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param things is the list of {@link Things}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public ThingsAdapter(Context context, ArrayList<Things> things, int colorResourceId) {
        super(context, 0, things);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.main_view, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Things currentWord = getItem(position);

// Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView thingsTextView = (TextView) listItemView.findViewById(R.id.things_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        thingsTextView.setText(currentWord.getThings());


// Find the ImageView in the list_item.xml layout with the ID image.
        ImageView ImageView = (ImageView) listItemView.findViewById(R.id.things_image);
        // If an image is available, display the provided image based on the resource ID
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
// Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }

}
