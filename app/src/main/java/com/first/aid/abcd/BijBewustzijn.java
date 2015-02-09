package com.first.aid.abcd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BijBewustzijn extends BaseClassABCD implements OnClickListener{
 Button bijbewustzijn, bewusteloos, brand;
 TextView beschrijving;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.bijbewustzijn);
	    bijbewustzijn = (Button)findViewById(R.id.btBijBewustzijn);
	    bewusteloos = (Button)findViewById(R.id.btBewustloos);
	    bijbewustzijn.setOnClickListener(this);
	    bewusteloos.setOnClickListener(this);
	    beschrijving = (TextView)findViewById(R.id.tvBewustBeschrijving);
	    beschrijving.setText("Slachtoffer is ....? ");
	    brand = (Button)findViewById(R.id.btBrand);
	    brand.setOnClickListener(this);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btBijBewustzijn:
			Class naarAirway;
			try {
				naarAirway = Class.forName("com.first.aid.abcd.Verslikking");
				Intent intentDrie = new Intent(BijBewustzijn.this, naarAirway);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentDrie);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.btBewustloos:
			Class naarVerslikking;
		try {
			naarVerslikking = Class.forName("com.first.aid.abcd.eersteHulp");
			Intent intentDrie = new Intent(BijBewustzijn.this, naarVerslikking);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			break;
		case R.id.btBrand:
			Class naarBrand;
			try {
				naarBrand = Class.forName("com.first.aid.abcd.Brand");
				Intent intentDrie = new Intent(BijBewustzijn.this, naarBrand);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentDrie);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}//einde switch
	}
	
	

}
