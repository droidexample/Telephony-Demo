package com.rama.telephony;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void dial(View v) {
		Intent intent = new Intent(MainActivity.this, TelephonyActivity.class);
		startActivity(intent);
	}

	public void sms(View v) {
		Intent intent = new Intent(MainActivity.this, SmsActivity.class);
		startActivity(intent);
	}
	public void mail(View v) {
		Intent intent = new Intent(MainActivity.this, Mail_Activity.class);
		startActivity(intent);
	}
}
