package com.rama.telephony;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends Activity {
	EditText phNumber, smsBody;
	Button sendManager, sendIntent, SendView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);

		phNumber = (EditText) findViewById(R.id.phoneNumber);
		smsBody = (EditText) findViewById(R.id.smsBody);
		sendManager = (Button) findViewById(R.id.smsManager);
		sendIntent = (Button) findViewById(R.id.smsIntent);
		SendView = (Button) findViewById(R.id.smsView);

		sendManager.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				smsSendByManager();
			}
		});

		sendIntent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				smsSendByIntent();
			}
		});
		SendView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				smsSendByView();
			}
		});
	}

	public void smsSendByManager() {
		try {
			String number = phNumber.getText().toString();
			String bodySms = smsBody.getText().toString();
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(number, null, bodySms, null, null);
			Toast.makeText(getApplicationContext(),
					"sms has sucessfully sent !", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "sms has failed...",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

	public void smsSendByIntent() {
		try {
			String number = phNumber.getText().toString();
			String bodySms = smsBody.getText().toString();

			Uri uri = Uri.parse("smsto:" + number);

			Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
			smsIntent.putExtra("sms_body", bodySms);

		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "sms has failed...",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

	public void smsSendByView() {

		try {
			String number = phNumber.getText().toString();
			String bodySms = smsBody.getText().toString();

			Intent intentView = new Intent(Intent.ACTION_VIEW);
			intentView.setType("vnd.android-dir/mms-sms");
			intentView.putExtra("smsNumber", number);
			intentView.putExtra("sms_body", bodySms);
			startActivity(intentView);
		} catch (Exception e) {

		}
	}
}
