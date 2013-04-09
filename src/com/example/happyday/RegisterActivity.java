package com.example.happyday;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {

	private Button registerButton;
	private EditText nameEditText, passEditText, passAgainEditText;
	private String name, password, passwordAgain;
	Intent intent;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.register_activity);
			
			nameEditText = (EditText) findViewById(R.id.nameEditText);
			passEditText = (EditText) findViewById(R.id.passEditText);
			passAgainEditText = (EditText) findViewById(R.id.passAgainEditText);
			
			registerButton = (Button) findViewById(R.id.acceptButton);
			
			registerButton.setOnClickListener(this);
			
		}
		
		@Override
		public void onClick(View v) {
			name = nameEditText.getText().toString();
			password = passEditText.getText().toString();
			passwordAgain = passAgainEditText.getText().toString();
			if(checkName(name) && checkPassword(password))
			{
				if(password.equals(passwordAgain))
				{
					intent = new Intent(this, AuthorisationActivity.class);
					startActivity(intent);
				}
				else
					Toast.makeText(this, "Check password again field", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(this, "You have unvalid or empty field", Toast.LENGTH_SHORT).show();
			
		}
		
		public static boolean checkName(String name)
		{
			Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{3,15}$");
			Matcher match = pattern.matcher(name);
			return match.matches();
		}
		
		public static boolean checkPassword(String pass)
		{
			Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{3,15}$");
			Matcher match = pattern.matcher(pass);
			return match.matches();
		}
}
