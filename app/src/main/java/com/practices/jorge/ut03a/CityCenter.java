package com.practices.jorge.ut03a;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class CityCenter extends AppCompatActivity {

    private MapView mapView;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString( R.string.AccessToken ));
        setContentView(R.layout.activity_city_center);
        mapView = findViewById( R.id.mapView );
        mapView.onCreate(savedInstanceState);

        //Importamos texto de Act.1
        this.bundle = getIntent().getExtras();

        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                String name = bundle.getString( "name" );
                Double latitude = bundle.getDouble("latitude");
                Double loyalty = bundle.getDouble("loyalty");

                CameraPosition position = new CameraPosition.Builder()
                        .target(new LatLng(latitude, loyalty)) // Fija la posición
                        .zoom(17) // Fija el nivel de zoom
                        .tilt(30) // Fija la inclinación de la cámara
                        .build();

                mapboxMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(position), 7000);

                mapboxMap.addMarker(new MarkerOptions()
                        .position( position.target )
                        .title( name )
                        .snippet("Latitud: " + latitude.toString() + " Longitud: " + loyalty.toString()) );



                messageToast( name );




                //mapboxMap.getCameraPosition();

                //onStart();

                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                    }
                });
            }


        });


        onStart();
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    // Muestra una tostada.
    private void messageToast(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }

}
