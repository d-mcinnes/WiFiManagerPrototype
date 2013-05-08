package com.example.wifimanagerprototype;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MapGreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_green);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onHeatmapCheck(View view) {
		//R.id.checkbox_compass.setChecked(false);
		CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox_heatmap);
		ImageView imagePrototype = (ImageView) findViewById(R.id.prototype_image);
		if(checkbox.isChecked()) {
			System.out.println("Checked");
			Drawable d = getResources().getDrawable(R.drawable.prototype_map_display);
			imagePrototype.setImageDrawable(d);
		} else {
			System.out.println("Not Checked");
			Drawable d = getResources().getDrawable(R.drawable.prototype_map_display_dots);
			imagePrototype.setImageDrawable(d);
		}
		//checkbox.setChecked(false);
		//startActivity(new Intent(this, CompassTestActivity.class));
	}

}
