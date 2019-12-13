package com.practices.jorge.ut03a;

import android.content.Intent;
import android.os.Bundle;

import com.practices.jorge.ut03a.Controllers.CityAdapter;
import com.practices.jorge.ut03a.Models.Cities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public ListView listViewCities;
    public Cities cities = new Cities();
    public CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        predefiniedCities();
        getVistas();
    }

    private void getVistas() {

        this.listViewCities = findViewById( R.id.listViewCities );
        this.adapter = new CityAdapter(this, cities.getCities());
        this.listViewCities.setAdapter( this.adapter );

        onclickItemList();
    }

    public void onclickItemList(){
        // Creo el listener para cuando se hace click en un item de la lista.
        listViewCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lst, View viewRow,
                                    int posicion, long id) {

               Intent intent = new Intent (viewRow.getContext(), CityCenter.class);

               intent.putExtra("name", cities.getName(posicion));
               intent.putExtra("latitude", cities.getLatitude(posicion));
               intent.putExtra("loyalty", cities.getLoyalty(posicion));
               startActivityForResult(intent, 0);

            }
        });
    }

    public void predefiniedCities(){

        cities.setCity(0, "Santa Cruz de Tenerife", 28.4636296, -16.2518467);
        cities.setCity( 0, "San Sebastián de La Gomera", 28.0937998, -17.1098582);
        cities.setCity( 0, "Santa Cruz de La Palma",28.6839885, -17.7645747);
        cities.setCity(1, "Las Palmas de Gran Canaria", 28.1235459, -15.4362574);
        cities.setCity(1, "Arrecife, Lanzarote", 28.9651694, -13.5550363);
        cities.setCity(1, "Puerto del Rosario, Fuerteventura", 28.500821, -13.8628367);
        cities.setCity(1, "Caleta del Sebo, La Graciosa", 29.2314646, -13.5034144);

    }

}
