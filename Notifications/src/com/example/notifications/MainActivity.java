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
		//显示自定义的通知
		button2= (Button)this.findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast = new Toast(MainActivity.this);
				//加载自定义布局
				View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item, null);
				ImageView imageView = (ImageView)view.findViewById(R.id.image);
				imageView.setImageResource(R.drawable.accept);
				TextView textView = (TextView)view.findViewById(R.id.text);
				textView.setText("自定义的吐司通知");
				toast.setDuration(1);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setView(view);
				toast.show();
			}
		});

	}

}
