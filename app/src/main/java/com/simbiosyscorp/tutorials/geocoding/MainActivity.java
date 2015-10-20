package com.simbiosyscorp.tutorials.geocoding;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
Button getLocation;
    EditText editText;
    TextView locationTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocation= (Button) findViewById(R.id.getLoc);
        editText= (EditText) findViewById(R.id.editText);
        locationTextView= (TextView) findViewById(R.id.locationText);
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = editText.getText().toString();
                List<Address> locations;
                //Instatiating GeoCoder for Geocoding - getting location from an address
                Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.US);
                try {
                    //getFromLocationName() function returns a list of Locations
                    // corresponding to the address.
                    // The second arguement specifies how many locations need to be returned
                    locations=geocoder.getFromLocationName(address,1);
                    locationTextView.setText("Location : ("+locations.get(0).getLatitude()+" , "+locations.get(0).getLongitude()+")");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
