package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Contact extends BaseClassABCD implements OnClickListener{
	TextView tekstbovenbericht;
	EditText tekstvak, emailadreszender, onderwerp;
	Button stuurEmail;
	String tekstvoorEmail, emailzender, stringOnderwerp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		tekstbovenbericht = (TextView)findViewById(R.id.tvContactText);
		onderwerp = (EditText)findViewById(R.id.etContactOnderwerp);
		emailadreszender =(EditText)findViewById(R.id.etContactEmail);
		tekstvak = (EditText)findViewById(R.id.etContactGeefBericht);
		stuurEmail = (Button)findViewById(R.id.btContactStuurEmail);
		stuurEmail.setOnClickListener(this);
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		convertEditTextVarsIntoStrings();
		String emailaddress[] = {"firstaidabcd@gmail.com"} ;
		String message = "Bericht = \n" + tekstvoorEmail
				+ "\n\n Afzender = \n" + emailzender;
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		//emailIntent.putExtra(android.content.Intent., emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, stringOnderwerp);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		startActivity(emailIntent);
		
		
	}
	private void convertEditTextVarsIntoStrings(){
		tekstvoorEmail = tekstvak.getText().toString();
		emailzender = emailadreszender.getText().toString();
		stringOnderwerp = onderwerp.getText().toString();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
