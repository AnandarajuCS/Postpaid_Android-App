package org.ericsson.hackathon;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class UsageScreenActivity extends Activity {
	Button chartButton;
	public static final String BUTTON_VALUE=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usage_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usage_screen, menu);
		return true;
	}
	 public void sendMessage(View view) // called when Button "Send" is clicked
	    {
	    	Intent optionsIntent = new Intent(this, DisplayOptionsActivity.class);
	    	
	    	switch(view.getId())
	    	{
	    	case R.id.calls_button:
	    		chartButton = (Button) findViewById(R.id.calls_button);
	    		optionsIntent.putExtra(BUTTON_VALUE,chartButton.getId());
	    		startActivity(optionsIntent);
	    		break;
	    	case R.id.sms_button:
	    		chartButton = (Button) findViewById(R.id.sms_button);
	    		optionsIntent.putExtra(BUTTON_VALUE,chartButton.getId());
	    		startActivity(optionsIntent);
	    		break;
	    	case R.id.data_button:
	    		chartButton = (Button) findViewById(R.id.data_button);
	    		optionsIntent.putExtra(BUTTON_VALUE,chartButton.getId());
	    		startActivity(optionsIntent);
	    		break;
	    	/*case R.id.bestplan_button:
	    		chartButton = (Button) findViewById(R.id.bestplan_button);
	    		bestPlanIntent.putExtra(BUTTON_VALUE,chartButton.getId());
	    		startActivity(bestPlanIntent);
	    		break;*/
	    	}
	    	
	    	
	    }

}
