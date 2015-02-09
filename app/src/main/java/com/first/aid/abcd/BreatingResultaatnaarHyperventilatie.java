package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BreatingResultaatnaarHyperventilatie extends BaseClassABCD implements OnClickListener{
Button naarHyper;
TextView resultaatBreating;
int aantalAdemhalingen;
Bundle getMand;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breatingresultaatnaarhyperventilatie);
		getMand = getIntent().getExtras();
		aantalAdemhalingen = getMand.getInt("sleutel");
        naarHyper = (Button)findViewById(R.id.btBrResNaarHyperventilatie);
        naarHyper.setOnClickListener(this);
        resultaatBreating = (TextView)findViewById(R.id.tvBrResNaarHyperventilatie);
        resultaatBreating.setText("Er zijn " + aantalAdemhalingen + " ademhalingen per minuut gemeten, dit is heel hoog. " +
        		"\nDe patient is waarschijnlijk aan het hyperventileren. \n\nDruk op de knop. \n");
	
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.Hyperventilatie");
			Intent intentDrie = new Intent(BreatingResultaatnaarHyperventilatie.this, ourClass3);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
