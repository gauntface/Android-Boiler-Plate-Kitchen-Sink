package co.uk.gauntface.android.kitchensink.activity;

import co.uk.gauntface.android.kitchensink.KitchenSinkActivity;
import co.uk.gauntface.android.kitchensink.R;
import co.uk.gauntface.android.kitchensink.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LaunchActivity extends KitchenSinkActivity {
    
	public static final String ACTION_SHOW_FORM_WIDGETS = "co.uk.gauntface.android.kitchensink.ACTION_SHOW_FORM_WIDGETS";
	public static final String ACTION_SHOW_DIALOGS = "co.uk.gauntface.android.kitchensink.ACTION_SHOW_DIALOGS";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen_sink);
    }
    
    @Override
    public void startActivity(Intent intent) {
    	String action = intent.getAction();
    	if(action != null) {
    		Intent newIntent = null;
    		if(action.equals(ACTION_SHOW_FORM_WIDGETS)) {
    			newIntent = new Intent(getApplicationContext(), FormWidgetActivity.class);
    		} else if(action.equals(ACTION_SHOW_DIALOGS)) {
    			newIntent = new Intent(getApplicationContext(), DialogActivity.class);
    		}
    		
    		if(newIntent != null) {
    			super.startActivity(newIntent);
    		}
    	} else {
    		super.startActivity(intent);
    	}
    }
}