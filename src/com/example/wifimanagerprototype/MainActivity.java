package com.example.wifimanagerprototype;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       /* R.id.home_map_container.setOnTouchListener(new OnTouchListener() {
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
            	// TODO Auto-generated method stub
            	return false;
            }
       });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
            	startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.action_home:
            	startActivity(new Intent(this, MainActivity.class));
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    public void mapClickEvent(View view) {
    	startActivity(new Intent(this, MapActivity.class));
    }
    
    public void compassClickEvent(View view) {
    	startActivity(new Intent(this, CompassActivity.class));
    }
    
    public void cameraClickEvent(View view) {
    	startActivity(new Intent(this, CameraActivity.class));
    }
}
