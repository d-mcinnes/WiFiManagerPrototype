package com.example.wifimanagerprototype;

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

public class CompassActivity extends Activity {
	private Activity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass);
		
		this.activity = this;
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
	        case R.id.action_home:
	    		startActivity(new Intent(this, MainActivity.class));
	    		return true;
        	case R.id.action_az:
            	startActivity(new Intent(this, CompassAZActivity.class));
            	return true;
        	case R.id.action_favorite:
            	startActivity(new Intent(this, CompassFavouritesActivity.class));
            	return true;
            case R.id.action_settings:
            	startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
	}
	
	public Activity mapGetActivity() {
		return this.activity;
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
    		builder.setMessage(getString(R.string.info_compass))
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
