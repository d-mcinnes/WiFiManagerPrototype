package com.example.wifimanagerprototype;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
	
	static final LatLng STLUCIACENTRE = new LatLng(-27.497356, 153.013317);
	static final LatLng STLUCIACENTRE_2 = new LatLng(-27.487356, 153.013317);
	static final LatLng STLUCIACENTRE_3 = new LatLng(-27.497385, 153.013598);
	static final LatLng STLUCIACENTRE_4 = new LatLng(-27.49994, 153.013887);
	private GoogleMap map;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		map.addMarker(new MarkerOptions()
			.position(STLUCIACENTRE)
			.title("eduroam")
			.snippet("joineduroam"));
		
		map.addMarker(new MarkerOptions()
			.position(STLUCIACENTRE_2)
			.title("joineduroam")
			.snippet("Connect to Eduroam."));
		
		map.addMarker(new MarkerOptions()
			.position(STLUCIACENTRE_3)
			.title("network")
			.snippet("Some network."));
		
		map.addMarker(new MarkerOptions()
			.position(STLUCIACENTRE_4)
			.title("Hawken")
			.snippet("Some network."));
		
		// Move the camera instantly to hamburg with a zoom of 15.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(STLUCIACENTRE, 16));

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//@Override
	//public void onAttachedToWindow() {
	//    openOptionsMenu(); 
	//}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case R.id.action_az:
        		startActivity(new Intent(this, MapAZActivity.class));
                return true;
        	case R.id.action_favorite:
        		startActivity(new Intent(this, MapFavoriteActivity.class));
                return true;
        	case R.id.action_relocate:
        		startActivity(new Intent(this, MapRelocateActivity.class));
                return true;
            case R.id.action_settings:
            	startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public void loadHeatmap(View view) {
    	startActivity(new Intent(this, MapGreenActivity.class));
    }

}
