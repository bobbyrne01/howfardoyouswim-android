package com.bobbyrne01.howfardoyouswim;

import com.bobbyrne01.howfardoyouswim.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView  tvConverted;
	private EditText  etPoolLength, etNumOfLengths;
	private Spinner poolMeasurementsSpinner, distanceMeasurementsSpinner;
	private double metersInMile = 0.000621371;
	private double metersInKilometer = 0.001;
	private double yardsInMile = 0.000568182;
	private double yardsInKilometer = 0.0009144;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvConverted = (TextView)findViewById(R.id.converted);
		etNumOfLengths = (EditText)findViewById(R.id.numOfLengthsInput);
		etPoolLength = (EditText)findViewById(R.id.distance);
		poolMeasurementsSpinner = (Spinner) findViewById(R.id.poolMeasurementsSpinner);
		distanceMeasurementsSpinner = (Spinner) findViewById(R.id.distanceMeasurementsSpinner);
		
		etNumOfLengths.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {calculate();}
	        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
	        public void onTextChanged(CharSequence s, int start, int before, int count) {}
	    });
		
		etPoolLength.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {calculate();}
	        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
	        public void onTextChanged(CharSequence s, int start, int before, int count) {}
	    });
		
		poolMeasurementsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {calculate();}
			public void onNothingSelected(AdapterView<?> arg0) {} 
		});
		
    	distanceMeasurementsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {calculate();}
			public void onNothingSelected(AdapterView<?> arg0) {} 
		});
	}
	
	private void calculate() {
		
		if (etPoolLength.getText().toString().compareTo("") == 0 ||
				etNumOfLengths.getText().toString().compareTo("") == 0){
			
			tvConverted.setText("");
			
		}else{

	    	if (poolMeasurementsSpinner.getSelectedItemPosition() == 0){
	    		
	    		if (distanceMeasurementsSpinner.getSelectedItemPosition() == 0){
	    			
	    			tvConverted.setText(String.valueOf(
	    					Double.valueOf(etPoolLength.getText().toString()) * 
	    					Double.valueOf(etNumOfLengths.getText().toString()) * 
	    					metersInKilometer));
	    			
	    		}else{
	    			
	    			tvConverted.setText(String.valueOf(
	    					Double.valueOf(etPoolLength.getText().toString()) * 
	    					Double.valueOf(etNumOfLengths.getText().toString()) * 
	    					metersInMile));
	    		}
	    		
	    	}else{
	    		
	    		if (distanceMeasurementsSpinner.getSelectedItemPosition() == 0){
	    			
	    			tvConverted.setText(String.valueOf(
	    					Double.valueOf(etPoolLength.getText().toString()) * 
	    					Double.valueOf(etNumOfLengths.getText().toString()) * 
	    					yardsInKilometer));
	    			
	    		}else{
	    			
	    			tvConverted.setText(String.valueOf(
	    					Double.valueOf(etPoolLength.getText().toString()) * 
	    					Double.valueOf(etNumOfLengths.getText().toString()) * 
	    					yardsInMile));
	    		}
	    	}
		}
	}
}