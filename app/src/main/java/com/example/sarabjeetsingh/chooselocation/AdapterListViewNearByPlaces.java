package com.example.sarabjeetsingh.chooselocation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sarabjeet Singh on 12/18/2015.
 */
public class AdapterListViewNearByPlaces extends ArrayAdapter<String> {
    private final Activity context;
    private final List<String> names;

    static class ViewHolder {
        public TextView text;
    }

    public AdapterListViewNearByPlaces(Activity context, List<String> names) {
        super(context, R.layout.row_list_view_nearby_places, names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.row_list_view_nearby_places, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.textView);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = names.get(position);
        holder.text.setText(s);


        return rowView;
    }
}