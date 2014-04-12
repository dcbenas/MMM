package com.example.hackathongame;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText username, password;
	private Button doLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		username = (EditText)findViewById(R.id.login_username);
		password = (EditText)findViewById(R.id.login_password);
		
		doLogin = (Button)findViewById(R.id.login_submit);
		doLogin.setOnClickListener(loginListener);

	}
	private OnClickListener loginListener = new OnClickListener(){
		public void onClick(View v){
			if (username.getText().toString().equals("admin") && password.getText().toString().equals("password")){
				Intent loggedIn = new Intent(getBaseContext(), MapScreen.class);
				loggedIn.putExtra("username", username.getText().toString());
				startActivity(loggedIn);
			} else {
				Toast.makeText(getApplicationContext(), "dumbass", Toast.LENGTH_LONG).show();
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
