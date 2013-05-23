package com.example.wifimanagerprototype;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class CompassTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass_test);
		
		CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_compass);
		checkbox.setChecked(true);
	}
	
	public void onCompassCheck(View view) {
		//R.id.checkbox_compass.setChecked(false);
		//startActivity(new Intent(this, CompassTestActivity.class));
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
