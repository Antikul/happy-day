package com.example.happyday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class StatActivity extends Activity implements OnClickListener {
	
	private Button changeButton, statButton;
	private TextView moodTextView;
	private int result;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stat_activity);
		
		result = getIntent().getExtras().getInt("result");
		
		moodTextView = (TextView) findViewById(R.id.moodTextView);
		moodTextView.setText(String.valueOf(result));
		
		changeButton = (Button) findViewById(R.id.decisionButton);
		statButton = (Button) findViewById(R.id.statButton);
		
		changeButton.setOnClickListener(this);
		statButton.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.decisionButton:
			intent = new Intent(this, ApplicationActivity.class);
			startActivity(intent);
			break;
		case R.id.statButton:
			intent = new Intent(this, WorldStatActivity.class);
			startActivity(intent);
			break;
		}
	}
}
