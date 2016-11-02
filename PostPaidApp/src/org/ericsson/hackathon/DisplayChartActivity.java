package org.ericsson.hackathon;

import org.ericsson.hackathon.PieChart;
import org.ericsson.hackathon.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DisplayChartActivity extends Activity implements OnClickListener{

	public String[] stubValues;
	public double[] chartValues;
	Button pieChart;
	ChartManipulation chartMani = new ChartManipulation();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_chart);
		Intent previousMenuIntent=getIntent();
		stubValues=previousMenuIntent.getStringArrayExtra(DisplayOptionsActivity.STUB_FEED);
	/*	TextView textView = new TextView(this);
		textView.setTextSize(15);
		textView.setText(stubValues[0]+stubValues[1]+stubValues[2]);*/
		//textView.setText(previousMenuIntent.getStringExtra(DisplayOptionsActivity.STUB_FEED));
		//setContentView(textView);
		/*chartValues=chartMani.setCategory(stubValues);*/
		pieChart=(Button)findViewById(R.id.pieChartButton);
		pieChart.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_chart, menu);
		return true;
	}
	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.pieChartButton:
			PieChart pie = new PieChart();
			pie.putValues(stubValues);
			Intent pieIntent = pie.getIntent(this);
			startActivity(pieIntent);
			break;
			
		}
	}
	

}
