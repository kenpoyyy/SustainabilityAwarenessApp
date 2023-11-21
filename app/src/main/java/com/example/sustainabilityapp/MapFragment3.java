package com.example.sustainabilityapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment3 extends Fragment {
    private GoogleMap googleMap;

    // The location of the event
    private static final LatLng LOCATION3 =
            new LatLng(1.2701833381781908, 103.79598791551251);

    // Method to update the map with a specific location
    public void updateMapWithLocation(double latitude, double longitude, String markerTitle, float zoomLevel) {
        if (googleMap != null) {
            LatLng location = new LatLng(latitude, longitude);

            // Create marker options for the specified location
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(location);
            markerOptions.title(markerTitle);

            // Clear existing markers, add the new marker, and adjust the camera position and zoom level
            googleMap.clear();
            googleMap.addMarker(markerOptions);

            // Adjust the camera position and zoom level
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(location, zoomLevel);
            googleMap.moveCamera(cameraUpdate);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the fragment's layout
        View view = inflater.inflate(R.layout.fragment_map3, container, false);

        // Find the SupportMapFragment in the layout
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.Map3);

        // Check if the SupportMapFragment is not null
        if (supportMapFragment != null) {

            // Asynchronously get the GoogleMap object when it's ready
            supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                    Log.d("MapFragment3", "onMapReady");
                    MapFragment3.this.googleMap = googleMap;

                    /*
                     * This code handles a map click event by placing a marker at a predefined location
                     * ("Singapore Discovery Center") and moving the camera to that location.
                     * The commented-out line //googleMap.clear(); is commented, so it won't clear any
                     * existing markers on the map. If uncommented, it would clear all existing
                     * markers before adding the new one.
                     */
                    googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                        @Override
                        public void onMapClick(@NonNull LatLng latLng) {
                            LatLng location3 = new LatLng(1.2701833381781908, 103.79598791551251);

                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.position(location3);
                            markerOptions.title("Pasir Panjang Ferry Terminal");

                            // Clear existing markers, add the new marker, and move the camera
                            googleMap.clear();
                            googleMap.addMarker(markerOptions);
                            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location3));

                        }
                    });

                    // Add the marker and move the camera when the map is ready
                    addMarkerAndMoveCamera(googleMap);
                }
            });
        }
        return view;
    }

    // Method to add a marker and move the camera to a predefined location
    private void addMarkerAndMoveCamera(GoogleMap googleMap) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(LOCATION3)
                .title("Pasir Panjang Ferry Terminal");

        // Add the marker to the map
        googleMap.addMarker(markerOptions);

        // Move the camera to the marker location with animation
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                LOCATION3, 15f); // Adjust the zoom level as needed
        googleMap.animateCamera(cameraUpdate);
    }
}