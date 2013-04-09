package com.example.wifimanagerprototype;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.ImageView;

public class CompassActivity extends Activity {
	private ImageView arrow;
	
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	
	private SensorEventListener mListener = new SensorEventListener() {
	    public void onSensorChanged(SensorEvent event){
	    	float[] values = {0, 0, 0};
	    	float[] m_rotationMatrix = new float[9], m_i = new float[9], m_lastMagFields = new float[3], m_lastAccels = new float[3];
			SensorManager.getRotationMatrix(m_rotationMatrix, m_i, m_lastMagFields, m_lastAccels);
	        SensorManager.getOrientation(m_rotationMatrix, values);
	        System.out.println("Orientation: " + values[0] + ", " + values[1] + ", " + values[2]);
	    	//if(event.sensor.getType() == SensorManager.getOrientation()){
	        //    System.out.println(event.values[0]);
	        //}
	    }

	    public void onAccuracyChanged(Sensor sensor, int accuracy){

	    }
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass);
		
		arrow = (ImageView) findViewById(R.id.compass_arrow);
        
		/**try {
			mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
			mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			
			mSensorManager.registerListener(mListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		} catch(NullPointerException e) {
			System.out.println("Null Pointer Exception");
		}**/
		
		//double angle = calculateAngle(currentLongitude, currentLatitude, targetLongitude, targetLatitude);
	    //Correction;
	    //angle-=90;

	    //Correction for azimuth
	    //angle-=azimuth;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_no_relocate, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        	case R.id.action_az:
            	startActivity(new Intent(this, CompassAZActivity.class));
            	return true;
            case R.id.action_settings:
            	startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
