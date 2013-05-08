package com.example.wifimanagerprototype;

//import android.location.Criteria;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.widget.TextView;

//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//public class MapActivity extends FragmentActivity implements LocationListener {
//	static final LatLng STLUCIACENTRE = new LatLng(-27.497356, 153.013317);
//	static final LatLng STLUCIACENTRE_2 = new LatLng(-27.487356, 153.013317);
//	static final LatLng STLUCIACENTRE_3 = new LatLng(-27.497385, 153.013598);
//	static final LatLng STLUCIACENTRE_4 = new LatLng(-27.49994, 153.013887);
//	private GoogleMap map;

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_map);
//		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
//		
//		map.addMarker(new MarkerOptions()
//			.position(STLUCIACENTRE)
//			.title("eduroam")
//			.snippet("joineduroam"));
//		
//		map.addMarker(new MarkerOptions()
//			.position(STLUCIACENTRE_2)
//			.title("joineduroam")
//			.snippet("Connect to Eduroam."));
//		
//		map.addMarker(new MarkerOptions()
//			.position(STLUCIACENTRE_3)
//			.title("network")
//			.snippet("Some network."));
//		
//		map.addMarker(new MarkerOptions()
//			.position(STLUCIACENTRE_4)
//			.title("Hawken")
//			.snippet("Some network."));
//		
//		// Check if Google Play services are available
//		if (status != ConnectionResult.SUCCESS) {
//			// Google Play services Unavailable
//			int requestCode = 10;
//            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
//            dialog.show();
//		} else {
//			// Getting reference to the SupportMapFragment of activity_main.xml
//			SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//			
//			// Getting GoogleMap object from the fragment
//			map = fm.getMap();
//			
//			// Enabling MyLocation Layer of Google Map
//			map.setMyLocationEnabled(true);
//			
//			// Getting LocationManager object from System Service LOCATION_SERVICE
//			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//			
//			// Creating a criteria object to retrieve provider
//			Criteria criteria = new Criteria();
//			
//			// Getting the name of the best provider
//			String provider = locationManager.getBestProvider(criteria, true);
//			
//			// Getting Current Location
//			Location location = locationManager.getLastKnownLocation(provider);
//			
//			if (location != null) {
//				onLocationChanged(location);
//				}
//			locationManager.requestLocationUpdates(provider, 20000, 0, this);
//		}
//	}
//
//	@Override
//	public void onLocationChanged(Location location) {
//		TextView tvLocation = (TextView) findViewById(R.id.tv_location);
//		
//		// Getting latitude of the current location
//		double latitude = location.getLatitude();
//		
//		// Getting longitude of the current location
//		double longitude = location.getLongitude();
//		
//		// Creating a LatLng object for the current location
//		LatLng latLng = new LatLng(latitude, longitude);
//		
//		// Showing the current location in Google Map
//		map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//		
//		// Zoom in the Google Map
//		map.animateCamera(CameraUpdateFactory.zoomTo(15));
//		
//		// Setting latitude and longitude in the TextView tv_location
//		tvLocation.setText("Latitude:" +  latitude  + ", Longitude:"+ longitude );
//	}
//
//	@Override
//	public void onProviderDisabled(String provider) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onProviderEnabled(String provider) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStatusChanged(String provider, int status, Bundle extras) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//	
//	@Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//        	case R.id.action_az:
//        		startActivity(new Intent(this, MapAZActivity.class));
//                return true;
//        	case R.id.action_favorite:
//        		startActivity(new Intent(this, MapFavoriteActivity.class));
//                return true;
//        	case R.id.action_relocate:
//        		startActivity(new Intent(this, MapRelocateActivity.class));
//                return true;
//            case R.id.action_settings:
//            	startActivity(new Intent(this, SettingsActivity.class));
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//}

/** Have to uncomment map stuff, as well as camera stuff in the CameraActivity.java class.
 ** This should be all you need to uncomment for the new code to work again.
 **/

public class MapActivity extends Activity {
	static final LatLng STLUCIACENTRE = new LatLng(-27.497356, 153.013317);
	static final LatLng STLUCIACENTRE_2 = new LatLng(-27.487356, 153.013317);
	static final LatLng STLUCIACENTRE_3 = new LatLng(-27.497385, 153.013598);
	static final LatLng STLUCIACENTRE_4 = new LatLng(-27.49994, 153.013887);
	private GoogleMap map;
	private Activity activity;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		this.activity = this;
		
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
		
		map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
			@Override
			public void onInfoWindowClick(Marker marker) {
				loadHeatmap(null);
			}
		});
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
	
	public Activity mapGetActivity() {
		return this.activity;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
	        case R.id.action_home:
	    		startActivity(new Intent(this, MainActivity.class));
	    		return true;
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
    
    public void loadInfo(View view) {
    	//System.out.println("DFDSFSFSDFSDFD FSDF DSFSD F SDFDS FF STUFF WORKS.");
    	// Load Heatmap
    	
    	/* Create Info Dialog */
    	//AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    	//builder.setMessage("Yeah this is a message")
    	//		.setTitle("Title");
    	//AlertDialog dialog = builder.create();
    	
    	DialogFragment newFragment = new InfoPaneFragment();
        newFragment.show(getFragmentManager(), "missiles");
    }
    
	@SuppressLint("ValidFragment")
	private class InfoPaneFragment extends DialogFragment {
    	@Override
    	public Dialog onCreateDialog(Bundle savedInstanceState) {
    		AlertDialog.Builder builder = new AlertDialog.Builder(mapGetActivity());
    		builder.setMessage(getString(R.string.info_map))
    			   .setTitle("Info");
    		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	               // User clicked OK button
    	           }
    	       });
			return builder.create();
    	}
    }
}
