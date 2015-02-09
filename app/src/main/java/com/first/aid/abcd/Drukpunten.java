package com.first.aid.abcd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Drukpunten extends BaseClassABCD implements OnClickListener{
	Button terug;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drukpunten);
		terug = (Button)findViewById(R.id.btDrukpuntenTerugWaarWeVandaanKwamen);
	    terug.setOnClickListener(this);
	}


	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		finish();
		
	}
	

}
