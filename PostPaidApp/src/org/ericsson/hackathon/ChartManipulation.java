package org.ericsson.hackathon;

public class ChartManipulation {
	
	String item,year,month;
	double[] valuesToChart=new double[3];

	public double[] setCategory(String[] values)
	{
		item=values[0];
		year=values[1];
		month=values[2];
	/*	return getValues();
	}
	public double[] getValues()
	{*/
		if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Jan")))
		{
			valuesToChart[0]=123.45; //Local
			valuesToChart[1]=551.70; //STD
			valuesToChart[2]=80.50;  //ISD
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Feb")))
		{
			valuesToChart[0]=225.90;
			valuesToChart[1]=88.92;
			valuesToChart[2]=0.0;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Mar")))
		{
			valuesToChart[0]=1639.40;
			valuesToChart[1]=13.45;
			valuesToChart[2]=183.85;	
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Apr")))
		{
			valuesToChart[0]=433.95;
			valuesToChart[1]=360.48;
			valuesToChart[2]=103.45;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("May")))
		{
			valuesToChart[0]=550.00;
			valuesToChart[1]=45.88;
			valuesToChart[2]=234.98;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Jun")))
		{
			valuesToChart[0]=990.55;
			valuesToChart[1]=4.45;
			valuesToChart[2]=143.76;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Jul")))
		{
			valuesToChart[0]=56.9;
			valuesToChart[1]=128.49;
			valuesToChart[2]=1.45;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Aug")))
		{
			valuesToChart[0]=13.32;
			valuesToChart[1]=523.57;
			valuesToChart[2]=30.80;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Sep")))
		{
			valuesToChart[0]=800.95;
			valuesToChart[1]=20.76;
			valuesToChart[2]=1200.00;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Oct")))
		{
			valuesToChart[0]=333.45;
			valuesToChart[1]=211.92;
			valuesToChart[2]=544.56;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Nov")))
		{
			valuesToChart[0]=90.66;
			valuesToChart[1]=12.70;
			valuesToChart[2]=333.89;
		}else if((item.equals("calls")||item.equals("sms")||item.equals("data"))&&(month.equals("Dec")))
		{
			valuesToChart[0]=223.44;
			valuesToChart[1]=119.34;
			valuesToChart[2]=88.76;
		}
		return valuesToChart;
	}
	
}
