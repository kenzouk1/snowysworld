package com.snowy.snowysworld;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback/*, MapWrapperLayout.OnDragListener*/ {

    private static final float ZOOM_SIZE = 8;
    private static final float MIN_ZOOM_SIZE = 5;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private GoogleMap mMap;
    private Marker addLocationMarker;

    private CustomMapFragment mCustomMapFragment;

    private View mMarkerParentView;
    private ImageView mMarkerImageView;

    private int imageParentWidth = -1;
    private int imageParentHeight = -1;
    private int imageHeight = -1;
    private int centerX = -1;
    private int centerY = -1;

    private TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId) {
            case R.id.filter:
                return true;
            case R.id.add:
//                LatLng center = mMap.getCameraPosition().target;
//                addLocationMarker = mMap.addMarker(new MarkerOptions()
//                        .position(center)
//                        .title("Add a location")
//                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_black_32px)));

                ImageView imageView = findViewById(R.id.add_location_pin);
                imageView.setVisibility(View.VISIBLE);


                Button addLocationButton = findViewById(R.id.add_location_button);
                addLocationButton.setVisibility(View.VISIBLE);
                return true;
            case R.id.search:
                return true;
            case R.id.all:
            case R.id.origin:
            case R.id.home:
            case R.id.home_stay:
            case R.id.hotel:
            case R.id.vacation:
            case R.id.restaurant:
            case R.id.grooming:
            case R.id.vet:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                mMap.clear();
                addMarkers(itemId);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(MIN_ZOOM_SIZE);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng manchester = new LatLng(53.030890, -1.802465);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(manchester, ZOOM_SIZE));

        addMarkers(R.id.all);
        enableMyLocationIfPermitted();

//        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
//            @Override
//            public void onCameraIdle() {
//                LatLng midLatLng = mMap.getCameraPosition().target;
//                getAddress(midLatLng.latitude, midLatLng.longitude);
//            }
//        });
    }


    public void addLocationButtonOnClick(View view) {
        Button addLocationButton = findViewById(R.id.add_location_button);
        addLocationButton.setVisibility(View.GONE);
        //addLocationMarker.setVisible(false);

        ImageView imageView = findViewById(R.id.add_location_pin);
        imageView.setVisibility(View.GONE);

        Intent intent = new Intent(this, AddLocationActivity.class);
        startActivity(intent);

    }


    private void addMarkers(int itemId) {
        for (com.snowy.snowysworld.Location location : SnowyLocations.get()) {
            if (location.getType().equals(Type.ORIGIN) && (itemId == R.id.all || itemId == R.id.origin) ) {
                addMarker(location, R.drawable.ic_marker_flag_pink_24px);
            } else if (location.getType().equals(Type.HOME) && (itemId == R.id.all || itemId == R.id.home)) {
                addMarker(location, R.drawable.ic_marker_push_pin_pink_24px);
            } else if (location.getType().equals(Type.HOME_STAY) && (itemId == R.id.all || itemId == R.id.home_stay)) {
                addMarker(location, R.drawable.ic_marker_ball_pink_24px);
            } else if (location.getType().equals(Type.HOTEL) && (itemId == R.id.all || itemId == R.id.hotel)) {
                addMarker(location, R.drawable.ic_marker_ball_pink_24px);
            } else if (location.getType().equals(Type.VACATION) && (itemId == R.id.all || itemId == R.id.vacation)) {
                addMarker(location, R.drawable.ic_marker_ball_chartreuse_24px);
            } else if (location.getType().equals(Type.RESTAURANT) && (itemId == R.id.all || itemId == R.id.restaurant)) {
                addMarker(location, R.drawable.ic_marker_ball_chartreuse_24px);
            } else if (location.getType().equals(Type.GROOMING) && (itemId == R.id.all || itemId == R.id.grooming)) {
                addMarker(location, R.drawable.ic_marker_ball_azure_24px);
            } else if (location.getType().equals(Type.VET) && (itemId == R.id.all || itemId == R.id.vet)) {
                addMarker(location, R.drawable.ic_marker_ball_azure_24px);
            }
        }
    }

    private void addMarker(com.snowy.snowysworld.Location location, int iconId) {
        MarkerOptions marker = new MarkerOptions()
                .position(new LatLng(location.getLatitude(), location.getLongitude()))
                .title(location.getDescription())
                .icon(BitmapDescriptorFactory.fromResource(iconId));
        mMap.addMarker(marker);
    }

    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocationIfPermitted();
                } else {
                    showDefaultLocation();
                }
                return;
            }

        }
    }
}
