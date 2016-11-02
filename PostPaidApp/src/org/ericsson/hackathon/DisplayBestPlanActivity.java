package org.ericsson.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class DisplayBestPlanActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_best_plan);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_best_plan, menu);
		return true;
	}
	public void BestPlan(View view){
		Intent BestPlanProceed = new Intent(this, BestPlanList.class);
		startActivity(BestPlanProceed);
	}

}
