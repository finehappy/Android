package com.example.guessapp;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.R.integer;
import android.content.Intent;
import android.media.audiofx.BassBoost.Settings;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private Random random = new Random();
	private int secret,value;
	private TextView message;
	private EditText guess;
	private Button button;
	//private Integer value2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		//random number between 1 and 10 inclusive
		secret = 1 + random.nextInt(10);
		
		button = (Button)this.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				message = (TextView)findViewById(R.id.message);
				guess = (EditText)findViewById(R.id.userguess);
				value = Integer.parseInt(guess.getText().toString());
				//value2 = Integer.getInteger(guess.getText().toString());
				if("".equals(guess.getText().toString().trim())){
					Toast.makeText(MainActivity.this, "Please enter a guess", 1).show();
					
				}else if(value > secret){
					message.setText("Try smaller!");
				}else if(value < secret){
					message.setText("Try bigger!");
				}else if(value == secret){
					message.setText("You Win!");
				}else {
					Toast.makeText(MainActivity.this, "Please enter a number", 1).show();
				}
			}
		});
	
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, Setting.class);
			startActivityForResult(intent, 1);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == 1 && resultCode == RESULT_OK){
			int min = data.getIntExtra("min", 1);
			int max = data.getIntExtra("max", 10);
			secret = min + random.nextInt(max -min +1);
			
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}


