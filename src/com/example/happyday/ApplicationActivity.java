package com.example.happyday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class ApplicationActivity extends Activity implements OnClickListener{

	private Button accesButton;
	private SeekBar bar;
	private TextView textView;
	private int result;
	Intent intent;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.app_activity);
			
			bar = (SeekBar) findViewById(R.id.happySeekBar);
			textView = (TextView) findViewById(R.id.resultTextView);
			bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					textView.setText(String.valueOf(bar.getProgress()));
					result = Integer.valueOf(bar.getProgress());
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					textView.setText(String.valueOf(bar.getProgress()));
				}
			});
			accesButton = (Button) findViewById(R.id.accesButton);
			accesButton.setOnClickListener(this);
		}
		
		@Override
		public void onClick(View v) {
			intent = new Intent(this, StatActivity.class);
			intent.putExtra("result", result);
			startActivity(intent);
		}
}
