package com.practices.jorge.ut03a.Models;

import java.util.ArrayList;

public class Cities {

    ArrayList<City> cities = new ArrayList<>();

    public void setCity( String name ) {
        cities.add( new City( name ) );
    }

    public void setCity( int id, String name, Double latitude, Double loyalty ) {
        cities.add( new City( id, name, latitude, loyalty ) );
    }

    public int getId( int id ){
        return this.cities.get( id ).getId();
    }

    public String getName( int id ){
        return this.cities.get( id ).getName();
    }

    public Double getLatitude( int id ){
        return this.cities.get( id ).getLatitude();
    }

    public Double getLoyalty( int id ){
        return this.cities.get( id ).getLoyalty();
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public ArrayList<City> deteteCity(int id ){
        this.getCities().remove(id);
        return this.getCities();
    }

    public boolean searchCitiesByID( int id ){
        ArrayList<Integer> ids = new ArrayList<Integer>();

        for ( int i = 0; i < this.getCities().size(); i++){
            ids.add( this.getCities().get( i ).getId() );
        }
        return ids.contains( id );
    }

}
