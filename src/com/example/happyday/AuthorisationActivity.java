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

public class AuthorisationActivity extends Activity implements OnClickListener {
	
	private Button enterButton, registrButton;
	private EditText loginEditText, passwordEditText;
	private String login, pass;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authorization_activity);
		
		loginEditText = (EditText) findViewById(R.id.loginEditText);
		passwordEditText = (EditText) findViewById(R.id.passwordEditText);
		
		enterButton = (Button) findViewById(R.id.enterButton);
		registrButton = (Button) findViewById(R.id.registrButton);
		
		enterButton.setOnClickListener(this);
		registrButton.setOnClickListener(this);
		
	}
		
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.enterButton:
			login = loginEditText.getText().toString();
			pass = passwordEditText.getText().toString();
			if(checkLogin(login) && checkPassword(pass))
			{
				intent = new Intent(this, ApplicationActivity.class);
				startActivity(intent);
				break;
			}
			else
				Toast.makeText(this, "Unvalid or empty field", Toast.LENGTH_SHORT).show();
			break;
		case R.id.registrButton:
			intent = new Intent(this, RegisterActivity.class);
			startActivity(intent);
			break;
		}
		
	}
	
	public static boolean checkLogin(String login)
	{
		Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{3,15}$");
		Matcher match = pattern.matcher(login);
		return match.matches();
	}
	
	public static boolean checkPassword(String password)
	{
		Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{3,15}$");
		Matcher match = pattern.matcher(password);
		return match.matches();
	}
}

