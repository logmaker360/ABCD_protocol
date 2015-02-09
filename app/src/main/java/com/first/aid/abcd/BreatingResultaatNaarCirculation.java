package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BreatingResultaatNaarCirculation extends BaseClassABCD implements OnClickListener {
TextView infoBreating;
ImageView pijl;
int aantalAdemhalingen = 0;
Bundle getMand;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breatingresultaatnaarcirculation);
		getMand = getIntent().getExtras();
		aantalAdemhalingen = getMand.getInt("sleutel");
		infoBreating = (TextView)findViewById(R.id.tvBrResNaarCirculation);
		pijl = (ImageView)findViewById(R.id.ivBrResNaarCirculation);
		pijl.setOnClickListener(this);
		
		if((aantalAdemhalingen > 9) && (aantalAdemhalingen < 12)){
			infoBreating.setText("Het aantal ademhaling is " + aantalAdemhalingen +
					" per minuut. \nDe patient ademt zelfstandig. Maar de Ademhaling is aan de zwakke kant." +
					"\nHou de ademhaling scherp in de gaten." +
					"\nGa verder: Druk op de pijl.");
		}else if((aantalAdemhalingen > 11) && (aantalAdemhalingen < 17)){
			infoBreating.setText("Het aantal ademhaling is " + aantalAdemhalingen +
					" per minuut. \nDe ademfrequentie heeft een mooi ritme." +
					"\nGa verder: Druk op de pijl.");
		}else if((aantalAdemhalingen > 16) && (aantalAdemhalingen < 24)){
			infoBreating.setText("Het aantal ademhaling is " + aantalAdemhalingen +
					" per minuut. \nDe Ademhaling is aan de hoge kant. " +
					"\nHou de ademhaling scherp in de gaten." +
					"Ga verder: Druk op de pijl.");
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.Circulation");
			Intent intentDrie = new Intent(BreatingResultaatNaarCirculation.this, ourClass3);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
