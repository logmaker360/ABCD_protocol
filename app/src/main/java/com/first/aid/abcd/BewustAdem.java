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
import android.widget.ImageView;
import android.widget.TextView;

public class BewustAdem extends BaseClassABCD implements OnClickListener{
TextView adem, naarKlaplong;
ImageView naarCirculatie;
Button hyperventilatie, stabielezijligging;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bewustadem);
		naarKlaplong = (TextView)findViewById(R.id.tvnaarKlaplong); 
		adem = (TextView)findViewById(R.id.tvTekstAdemhaling);
		naarCirculatie = (ImageView)findViewById(R.id.ibPijlNaarCirulatie);
		hyperventilatie =(Button)findViewById(R.id.btHyperventilatie);
		stabielezijligging = (Button)findViewById(R.id.btStabieleZijliggingBewustAdem);
		hyperventilatie.setOnClickListener(this);
		naarCirculatie.setOnClickListener(this);
		stabielezijligging.setOnClickListener(this);
		
		adem.setText("Nu de luchtweg vrij is, luistert u naar de ademfrequentie, " +
				"\n\n-Is de ademhaling te snel, dan is de kans groot dat de patient hyperventileert." +
				"\nHyperventilatie komt veel voor bij mensen die in paniek zijn."  
				);
		
		naarKlaplong.setText("\n-Verraad de lichaamshouding benauwdheid, aan een kant van het lichaam. " +
				"Dan bestaat er kans op een klaplong. Een long werkt dan niet meer. Zet de patient in een halfzittende houding" +
				"(bv: Benen gestrekt op de grond, rug tegen de muur)\n\n" +
				"Is de patient verwond aan zijn borst, dan kan het zijn dat een long van buitenaf lek is geraakt." +
				"\n\nMaak de wond schoon en plak die aan 3 zijden af. Hierdoor wordt de overdruk opgeheven en kan de long weer gaan functioneren. Doe dit alleen als u weet hoe dit moet" +
				"\n\n Raakt de patient bewustloos, leg hem dan in de stabiele zijligging met de gewonde kant op de grond. " +
				"\nZodat zijn gezonde long optimaal kan blijven werken."  
				);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.ibPijlNaarCirulatie:
		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.Circulation");
			Intent intentDrie = new Intent(BewustAdem.this, ourClass3);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    break;
		case R.id.btHyperventilatie:
			Class ourClass5;
			try {
				ourClass5 = Class.forName("com.first.aid.abcd.Hyperventilatie");
				Intent intentVijf = new Intent(BewustAdem.this, ourClass5);
				intentVijf.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentVijf);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.btStabieleZijliggingBewustAdem:
		Class ourClass6;
		try {
			ourClass6 = Class.forName("com.first.aid.abcd.Stabiele_zijligging");
			Intent intentZes = new Intent(BewustAdem.this, ourClass6);
			intentZes.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentZes);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			break;
	}
	
	}
	
}
