package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Hyperventilatie extends BaseClassABCD implements OnClickListener{
Button terug, naarBreating;
TextView teSnel, infoTerug;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hyperventilatie);
		teSnel = (TextView)findViewById(R.id.tvHyperventilatieText);
		infoTerug = (TextView)findViewById(R.id.tvHyperventilatieTerug);
		terug = (Button)findViewById(R.id.btHyperventilatieTerug);
		terug.setOnClickListener(this);
		naarBreating = (Button)findViewById(R.id.btHyperVentilatieNaarBewustloosBreating);
		naarBreating.setOnClickListener(this);
		
		teSnel.setText("Is de ademfrequentie hoger dan 1 ademhaling in de 2 seconden dan is de patient waarschijnlijk aan het hyperventileren" +
				"\n\nHet lichaam ademt meer CO2 uit, dan het inademt." +
				"\n\nStel de patient gerust. Vraag hem even zijn adem intehouden." +
				"\nTel langzaam tot 10, en laat de patient bij iedere tel inademen." +
				"\n\nHelpt dit niet, laat de patient dan zijn handen voor zijn mond houden. " +
				"Hierdoor ademt hij dezelfde lucht in, die hij zojuist heeft uitgeademt. " +
				"Waardoor het CO2 gehalte in het bloed van de patient weer zal stijgen" +
				"\n\nIndien mogelijk maak van uw eigen handen een kommetje, wat u voor zijn mond houdt. " +
				"\n\nVerliest de patient het bewustzijn, leg hem dan plat op de grond. Eventueel zijn benen iets van de grond" +
				"\nBlijf zijn ademhaling controleren. Waarschijnlijk wordt de frequentie snel weer normaal, en zal de patient weer bijkomen." +
				"\n\n Stopt de patient echter met ademen, of verslechterd de situatie van de patient: druk dan op onderstaande knop."
				);
		infoTerug.setText("Gaat het beter met de pati�nt, druk dan op de terug knop.");
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btHyperventilatieTerug:
		finish();
       break;
		case R.id.btHyperVentilatieNaarBewustloosBreating:
			Class ourClass4;
			try {
				ourClass4 = Class.forName("com.first.aid.abcd.Breating");
				Intent intentVier = new Intent(Hyperventilatie.this, ourClass4);
				//intentVier.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentVier);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		}	
	}
	

}
