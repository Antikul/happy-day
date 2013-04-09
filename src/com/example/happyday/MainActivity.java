package com.example.happyday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button authButton, startButton;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.general_activity);
		
		authButton = (Button) findViewById(R.id.authButton);
		startButton = (Button) findViewById(R.id.startButton);
		
		authButton.setOnClickListener(this);
		startButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.authButton:
			intent = new Intent(this, AuthorisationActivity.class);
			startActivity(intent);
			break;
		case R.id.startButton:
			intent = new Intent(this, ApplicationActivity.class);
			startActivity(intent);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.general_activity, menu);
		return true;
	}
}

