package com.example.d_odo.jsonparser.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.d_odo.jsonparser.R;
import com.example.d_odo.jsonparser.models.Place;

import java.util.ArrayList;

/**
 * Created by d-odo on 02/03/2017.
 */
public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder> {

    private ArrayList<Place> dataSet = new ArrayList<>();

    public void setDataSet(ArrayList<Place> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }
    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);

        return  new PlaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {

        Place place = dataSet.get(position);
        holder.placeName.setText(place.getName());
        holder.placeAddress.setText(place.getAddress());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder{

        TextView placeName;
        TextView placeAddress;
        ImageButton placeMaps;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            placeName = (TextView) itemView.findViewById(R.id.place_name);
            placeAddress = (TextView) itemView.findViewById(R.id.place_address);
            placeMaps = (ImageButton) itemView.findViewById(R.id.place_maps);

            placeMaps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(v.getId() == R.id.place_maps) {
                        Intent i = new Intent();
                        i.setAction(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse("geo:0,0?q= " + placeAddress.getText().toString());
                        i.setData(uri);
                        v.getContext().startActivity(i);
                    }

                }
            });
        }
    }
}
