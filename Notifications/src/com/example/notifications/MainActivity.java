package com.example.notifications;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	private Button button1,button2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		button1= (Button)this.findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(), "notification", 1);
				toast.setGravity(Gravity.CENTER, 0, 0);//设置通知显示的位置
				toast.show();
				
				
			}
		});
		

	}

}
