package com.example.guessapp;

import com.example.guessapp.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class Setting extends ActionBarActivity {
	private EditText minimum,maximum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		minimum = (EditText)this.findViewById(R.id.minimum);
		maximum = (EditText)this.findViewById(R.id.maximum);
	}
	public void handleDone(View view){
		int min = Integer.parseInt(minimum.getText().toString());
		int max = Integer.parseInt(maximum.getText().toString());
		
		Intent dataIntent = new Intent();
		dataIntent.putExtra("min", min);
		dataIntent.putExtra("max", max);
		
		setResult(RESULT_OK, dataIntent);
		finish();
	}

	public Setting() {
		// TODO Auto-generated constructor stub
	}

}
