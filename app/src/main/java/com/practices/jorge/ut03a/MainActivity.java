package com.practices.jorge.ut03a;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.practices.jorge.ut03a.Controllers.CityAdapter;
import com.practices.jorge.ut03a.Models.Cities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
                messageToast(getString(R.string.messageClickItem) + lst.getItemAtPosition( posicion ));
            }
        });
    }


    // Muestra una tostada.
    private void messageToast(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

    public void predefiniedCities(){

        cities.setCity( 0, "Madrid", 1000.0, 2000.0 );

    }


}
