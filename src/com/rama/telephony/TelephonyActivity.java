package com.rama.telephony;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelephonyActivity extends Activity {
	EditText number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_telephony);

		number = (EditText) findViewById(R.id.etNumber);

	}

	public void call(View v) {
		try {
			String phoneNumber = number.getText().toString();
			Intent intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:" + phoneNumber));
			startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), e.getMessage(),
					Toast.LENGTH_LONG).show();
		}
	}

	public void back(View v) {
		try {
			Intent intent = new Intent(TelephonyActivity.this,
					MainActivity.class);
			startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
