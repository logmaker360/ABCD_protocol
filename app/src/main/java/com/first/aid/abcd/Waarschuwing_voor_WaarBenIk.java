package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Waarschuwing_voor_WaarBenIk extends BaseClassABCD implements OnClickListener{
	Button terug, naarLocatie;
	TextView waarschuwing, doorgaan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.waarschuwingvoorwaarbenik);
		terug = (Button)findViewById(R.id.btTerug_naar_Alarmeren);
		naarLocatie = (Button)findViewById(R.id.btNaarLocatieZoeker);
		terug.setOnClickListener(this);
		naarLocatie.setOnClickListener(this);
		waarschuwing = (TextView)findViewById(R.id.tvWaarschuwing);
		doorgaan = (TextView)findViewById(R.id.tvDoorgaan);
		waarschuwing.setText("Waarschuwing, het vinden van uw huidige adres kost tijd. " +
				"\n\nVaak is het sneller om een omstander het adres op te laten zoeken. " +
				"\n\nEn hem het alarmnummer te laten bellen. " +
				"\n\nDruk op de terug knop als u wilt afsluiten.\n\n\n");
		doorgaan.setText("Zet GPS en internet aan, het adres kan alleen worden gevonden als dit toestel contact maakt met internet." +
				"\n\nBij geen internet toont deze app alleen de lengte en breedte graad. " +
				"\n\nLet op... Binnen in gebouwen, kan dit toestel geen contact maken met satalieten." +
				"\nZorg dat u buiten bent.");
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btTerug_naar_Alarmeren:
			//ga naar Activity vierde
			Class ourClass4;
			try {
				ourClass4 = Class.forName("com.first.aid.abcd.vierde");
				Intent intentVier = new Intent(Waarschuwing_voor_WaarBenIk.this, ourClass4);
				startActivity(intentVier);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
			
		case R.id.btNaarLocatieZoeker:
			//ga naar Activity Locatie
			Class ourClass1;
			try {
				ourClass1 = Class.forName("com.first.aid.abcd.Locatie");
				Intent intentEen = new Intent(Waarschuwing_voor_WaarBenIk.this, ourClass1);
				intentEen.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentEen);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		}
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
