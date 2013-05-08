package com.example.wifimanagerprototype;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.util.Log;

public class CameraActivity extends Activity {
	private static final String TAG = "Compass";
	private static boolean DEBUG = true;
	private SensorManager mSensorManager;
	private Sensor mSensor;
	private DrawSurfaceView mDrawView;
	LocationManager locMgr;
	
	private final SensorEventListener mListener = new SensorEventListener() {
		public void onSensorChanged(SensorEvent event) {
			if (mDrawView != null) {
	            mDrawView.setOffset(event.values[0]);
	            mDrawView.invalidate();
	        }
		}
		
		public void onAccuracyChanged(Sensor sensor, int accuracy) {	
		}
	};
		
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		setContentView(R.layout.activity_camera);
		
		mDrawView = (DrawSurfaceView) findViewById(R.id.drawSurfaceView);
		
		locMgr = (LocationManager) this.getSystemService(LOCATION_SERVICE); // <2>
		LocationProvider high = locMgr.getProvider(locMgr.getBestProvider(
				LocationUtils.createFineCriteria(), true));

		// using high accuracy provider... to listen for updates
		locMgr.requestLocationUpdates(high.getName(), 0, 0f, new LocationListener() {
			public void onLocationChanged(Location location) {
				// do something here to save this new location
				Log.d(TAG, "Location Changed");
				mDrawView.setMyLocation(location.getLatitude(), location.getLongitude());
				mDrawView.invalidate();
			}

			public void onStatusChanged(String s, int i, Bundle bundle) {

			}

			public void onProviderEnabled(String s) {
				// try switching to a different provider
			}

			public void onProviderDisabled(String s) {
				// try switching to a different provider
			}
		});
	}
	
	@Override
	protected void onResume() {
		if (DEBUG) {
			Log.d(TAG, "onResume");
		}
		super.onResume();

		mSensorManager.registerListener(mListener, mSensor, SensorManager.SENSOR_DELAY_GAME);
	}
	
	@Override
	protected void onPause() {
	    mSensorManager.unregisterListener(mListener);
	    super.onPause();
	}

	@Override
	protected void onStop() {
		if (DEBUG) {
			Log.d(TAG, "onStop");
		}

		mSensorManager.unregisterListener(mListener);
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_no_relocate, menu);
		return true;
	}
	
	public void onCompassCheck(View view) {
		//R.id.checkbox_compass.setChecked(false);
		CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_compass);
		checkbox.setChecked(false);
		startActivity(new Intent(this, CompassTestActivity.class));
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case R.id.action_home:
        		startActivity(new Intent(this, MainActivity.class));
        		return true;
        	case R.id.action_az:
            	startActivity(new Intent(this, CameraAZActivity.class));
            	return true;
            case R.id.action_settings:
            	startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
