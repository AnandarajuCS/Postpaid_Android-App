package org.ericsson.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class BestPlanTryout extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_best_plan_tryout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.best_plan_tryout, menu);
		return true;
	}
public void SuggestedPlanActivate(View view)
{
	Intent ConfirmActivationIntent = new Intent(this, ConfirmActivationSuggestedPlan.class);
	startActivity(ConfirmActivationIntent);
}
}
