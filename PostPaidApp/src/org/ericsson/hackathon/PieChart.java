package org.ericsson.hackathon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class PieChart {
	public double[] chartValues;
	public String[] stubValues;
	ChartManipulation chartMani = new ChartManipulation();
	public void putValues(String[] val)
	{
		stubValues=val;
	}
	public Intent getIntent(Context context)
	{
		/*Intent previousMenuIntent=getIntent(context);
		stubValues=previousMenuIntent.getStringArrayExtra(DisplayOptionsActivity.STUB_FEED);*/
		chartValues=chartMani.setCategory(stubValues);
		//chartValues=chartMani.getValues();
		//int[] calls = {45,21,9};
		double currentDataPlan=500.00;
		CategorySeries series = new CategorySeries("pie");
		String cat1=null;
		String cat2=null;
		String cat3 =null;
		if(stubValues[0].equals("calls"))
		{
			cat1="Local";
			cat2="STD";
			cat3="ISD";
			series.add(cat1,chartValues[0]);
			series.add(cat2,chartValues[1]);
			series.add(cat3,chartValues[2]);
		}else if(stubValues[0].equals("sms"))
		{
			cat1="Local";
			cat2="National";
			cat3="International";
			series.add(cat1,chartValues[0]);
			series.add(cat2,chartValues[1]);
			series.add(cat3,chartValues[2]);
		}else{
			series.add("Used Data",chartValues[0]);
			if(currentDataPlan-chartValues[0]<0){
				series.add("Excess Usage",chartValues[0]-currentDataPlan);
			}else{
			series.add("Unused Data",currentDataPlan-chartValues[0]);
			}
		}
		
		int[] colors = new int[]{Color.RED,Color.GREEN,Color.BLUE};
		DefaultRenderer renderer = new DefaultRenderer();
		if(stubValues[0].equals("calls")||stubValues[0].equals("sms"))
		{
		for(int color: colors)
		{
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(color);
			r.setDisplayBoundingPoints(true);
			r.setDisplayChartValues(true);
			r.setDisplayChartValuesDistance(5);
			r.setChartValuesTextSize(15);
			renderer.addSeriesRenderer(r);
		}}else{
			int[] dataColors = new int[]{Color.RED,Color.GREEN};
			for(int color:dataColors){
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(color);
			r.setDisplayBoundingPoints(true);
			r.setDisplayChartValues(true);
			r.setDisplayChartValuesDistance(5);
			r.setChartValuesTextSize(15);
			renderer.addSeriesRenderer(r);
			}}
		renderer.isInScroll();
		renderer.setZoomButtonsVisible(true);
		renderer.setApplyBackgroundColor(true);
		renderer.setBackgroundColor(Color.YELLOW);
		renderer.setChartTitle(stubValues[0]+"-Chart");
		renderer.setChartTitleTextSize((float)30);
		renderer.setShowLabels(true);
		renderer.setLabelsTextSize(20);
		renderer.setLegendTextSize(25);
		renderer.setDisplayValues(true);
		return ChartFactory.getPieChartIntent(context, series, renderer, "PieChart");
		
		
	}

}
