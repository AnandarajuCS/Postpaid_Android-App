package org.ericsson.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity {
	Intent secondPageIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void secondDetailPage(View view)
	{
		
		switch(view.getId())
		{
		case R.id.usageMenu:
			secondPageIntent = new Intent(this,UsageScreenActivity.class);
			break;
		case R.id.bestPlanMenu:
			secondPageIntent = new Intent(this,DisplayBestPlanActivity.class);
			break;
		case R.id.billPayMenu:
			secondPageIntent=new Intent(this,ComingSoonActivity.class);
			break;
		case R.id.alarmsMenu:
			secondPageIntent=new Intent(this,ComingSoonActivity.class);
			break;
		}
		startActivity(secondPageIntent);
	}
}
