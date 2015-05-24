package com.rama.telephony;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Mail_Activity extends Activity {
	EditText etMail, etSubject, etMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail_);
		etMail = (EditText) findViewById(R.id.etMail);
		etSubject = (EditText) findViewById(R.id.etSubject);
		etMessage = (EditText) findViewById(R.id.etMessage);
	}

	public void send(View v) {
		String to = etMail.getText().toString();
		String subject = etSubject.getText().toString();
		String message = etMessage.getText().toString();

		Intent emailIntent = new Intent(Intent.ACTION_SEND);

		emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);

		emailIntent.setType("message/rfc822");

		startActivity(Intent.createChooser(emailIntent,
				"select your provide email"));
	}

}
