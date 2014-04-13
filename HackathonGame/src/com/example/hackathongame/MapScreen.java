package com.example.hackathongame;


import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.app.AlarmManager;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;
import android.graphics.Color;

import java.util.Random;

public class MapScreen extends Activity {
	
	
	private GoogleMap Map;
	private LocationManager locationManager;
	private MyLocationListener mylistener;
	private Criteria criteria;
	private String provider;
	private double lat;
	private double lng;
	private Marker yourMarker;
	public double[][] markerArray = new double[10][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);
       
        if(Map==null) {
            //map not instantiated yet
        	Map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
        	if(Map != null){
        	    //ok - proceed
        		Map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        	       criteria = new Criteria();
        	       criteria.setAccuracy(Criteria.ACCURACY_FINE);   //default
        	       criteria.setCostAllowed(false);
        	       provider = locationManager.getBestProvider(criteria, false);
        	       Location location = locationManager.getLastKnownLocation(provider);
        	       System.out.print(location);
        	       mylistener = new MyLocationListener();
        	       if (location == null) {
                       locationManager.requestLocationUpdates(
                               LocationManager.GPS_PROVIDER,
                               200,
                              1, mylistener);
                       Log.d("GPS", "GPS Enabled");
                       if (locationManager != null) {
                           location = locationManager
                                   .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                           if (location != null) {
                               lat = location.getLatitude();
                               lng = location.getLongitude();
                           }
                       }
        	       }
        	       
        	       for (int i = 0; i<10; i++) {
        	    	double moddedLat = lat + ((Math.random()*.008) - .004);
        	    	double moddedLng = lng + ((Math.random()*.008) - .004);
        	    	Random rand = new Random();
        	    	int rar = rand.nextInt(5) + 1;
        	    	String rare = Integer.toString(rar);
        	    	markerArray[i][0] = moddedLat;
        	    	markerArray[i][1] = moddedLng;
        	    	markerArray[i][2] = rar;
        	    	
           			Map.addMarker(new MarkerOptions()
           				.position(new LatLng(moddedLat, moddedLng))
           				.title(rare)
           				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                           
        	       if (location != null) {
        	    	   mylistener.onLocationChanged(location);
        	       }
        	       
        	    locationManager.requestLocationUpdates(provider, 200, 1, mylistener);
        	    
        		Map.setMyLocationEnabled(true);
     
        		
        		
        	
        		}
        }
    }
   }private class MyLocationListener implements LocationListener {
	   
	             @Override
	             public void onLocationChanged(Location location) {
	               // Initialize the location fields
	                 lat = location.getLatitude();	   
	                 lng = location.getLongitude();     
	                 if (yourMarker != null) yourMarker.remove();
	         	     yourMarker = Map.addMarker (new MarkerOptions()
	                 	.position(new LatLng(lat, lng))
	                 	.title("Your Location"));
	             }
	             @Override
	             public void onStatusChanged(String provider, int status, Bundle extras) {  
	             }

	             @Override	   
	             public void onProviderEnabled(String provider) {
	             }
	  
	             @Override
	             public void onProviderDisabled(String provider) {
	             }
	   
	         }
        	}

