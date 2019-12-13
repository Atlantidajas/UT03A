package com.practices.jorge.ut03a.Controllers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.practices.jorge.ut03a.Models.City;
import com.practices.jorge.ut03a.R;

import java.util.ArrayList;


public class CityAdapter extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<City> items;

    public CityAdapter(Activity activity, ArrayList<City> items ) {//< Una lista de ciudades
        this.activity = activity;
        this.items = items;
    }

    public CityAdapter(Activity activity, City item ) { //<-- Un sala ciudad
        this.activity = activity;
        this.items.add( item );
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View view = contentView;

        if( contentView == null ) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            view = inflater.inflate( R.layout.content_main, null);
        }

        City item = items.get(position);

        TextView txVwName = (TextView) view.findViewById( R.id.txVwName );//<-- Nombre Ciudad
        txVwName.setText( item.getName() );

        return view;
    }
}