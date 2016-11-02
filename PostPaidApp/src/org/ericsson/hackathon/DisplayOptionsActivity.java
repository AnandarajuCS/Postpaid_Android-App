package org.ericsson.hackathon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.ericsson.hackathon.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
// import android.widget.Toast;

public class DisplayOptionsActivity extends Activity implements OnItemSelectedListener{

	Calendar now = Calendar.getInstance();
	public String yearSelected=null;
	public String monthSelected=null;
	public int buttonId=0;
	public String buttonSelected=null;
	public static String STUB_FEED=null;
	Spinner yearSpinner;
	Spinner monthSpinner;
	Button pieChart;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_options);
		yearDropDown();
		monthDropDown();
		itemSelection(); // this is to create the item selection variables for year and month
		Intent previousIntent=getIntent();
		buttonId=previousIntent.getIntExtra(UsageScreenActivity.BUTTON_VALUE,0);
		switch(buttonId)
		{
		case R.id.calls_button:
			buttonSelected="calls";
			break;
		case R.id.sms_button:
			buttonSelected="sms";
			break;
		case R.id.data_button:
			buttonSelected="data";
			break;	
		}
		/*pieChart=(Button)findViewById(R.id.pieChart);
		pieChart.setOnClickListener(this);*/
	}

	public void itemSelection()
	{
		yearSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent,View view, int position, long id)
			{
				String item = parent.getItemAtPosition(position).toString();
				yearSelected=item;
			//	Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
				
			}
			
			public void onNothingSelected(AdapterView<?> arg0) {
		        // TODO Auto-generated method stub
		    }
		});
		
		monthSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent,View view, int position, long id)
			{
				String item = parent.getItemAtPosition(position).toString();
				monthSelected=item;
			//	Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
				
			}
			
			public void onNothingSelected(AdapterView<?> arg0) {
		        // TODO Auto-generated method stub
		    }
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_options, menu);
		return true;
	}
	
	@Override
	public void onItemSelected(AdapterView<?> parent,View view, int position, long id)
	{
		/*String item = parent.getItemAtPosition(position).toString();
		Log.v("parentId",Long.toString(parent.getItemIdAtPosition(position)));
		if(view.getId()==R.id.yearSpinner)
		{
			yearSelected=item;
			Log.v("year", yearSelected);
		}else if(view.getId()==R.id.monthSpinner)
		{
		    monthSelected=item;	
		    Log.v("month", monthSelected);
		}
		
		Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
		values.add(item);*/
		
	}
	
	public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

	public void yearDropDown()
	{
		yearSpinner = (Spinner)findViewById(R.id.yearSpinner);
		yearSpinner.setOnItemSelectedListener(this);
		List<Integer> yearCategories = new ArrayList<Integer>();
		
		int currYear=now.get(Calendar.YEAR);
		for(int i=0;i<10;i++)
		{
			yearCategories.add(currYear);
			currYear--;
		}
		ArrayAdapter<Integer> yearDataAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,yearCategories);
		yearDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		yearSpinner.setAdapter(yearDataAdapter);
	}
	public void monthDropDown()
	{
		monthSpinner = (Spinner)findViewById(R.id.monthSpinner);
		monthSpinner.setOnItemSelectedListener(this);
		List<String> monthCategories = new ArrayList<String>();
		monthCategories.add("Jan");
		monthCategories.add("Feb");
		monthCategories.add("Mar");
		monthCategories.add("Apr");
		monthCategories.add("May");
		monthCategories.add("Jun");
		monthCategories.add("Jul");
		monthCategories.add("Aug");
		monthCategories.add("Sep");
		monthCategories.add("Oct");
		monthCategories.add("Nov");
		monthCategories.add("Dec");
		ArrayAdapter<String> monthDataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,monthCategories);
		monthDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		monthSpinner.setAdapter(monthDataAdapter);
		
	}
	public void toDisplayChart(View view)
	{
		//PieChart pie = new PieChart();
		String[] stubFeed=new String[3];
		stubFeed[0]=buttonSelected;
		stubFeed[1]=yearSelected;
		stubFeed[2]=monthSelected;
		/*switch(view.getId())
		{
		case R.id.pieChart:
			Intent pieIntent = pie.getIntent(this,stubFeed);
			startActivity(pieIntent);
			break;
		}*/
		Intent chartIntent = new Intent(this,DisplayChartActivity.class);
		chartIntent.putExtra(STUB_FEED, stubFeed);
		startActivity(chartIntent);
	}
	
/*	@Override
	public void onClick(View v)
	{
		String[] stubFeed=new String[3];
		stubFeed[0]=buttonSelected;
		stubFeed[1]=yearSelected;
		stubFeed[2]=monthSelected;
		PieChart pie = new PieChart();
		//pie.putValues(stubFeed);
		switch(v.getId())
		{
		case R.id.pieChart:
			Intent pieIntent = pie.getIntent(this,stubFeed);
			startActivity(pieIntent);
			break;
		}
	}
	*/
}
