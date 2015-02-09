package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Ader_of_Slagaderlijke_bloeding extends Activity implements OnClickListener{
Button terug, drukpunten;
TextView Slagader, Ader;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slagader);
		Slagader = (TextView)findViewById(R.id.tvKlaplongText);
		Ader = (TextView)findViewById(R.id.tvAderText);
		terug = (Button)findViewById(R.id.btSlagAderTerug);
		terug.setOnClickListener(this);
		drukpunten = (Button)findViewById(R.id.btSlagaderDrukpunten);
		drukpunten.setOnClickListener(this);
		
		Slagader.setText("-SlagAder:" +
				"\nBij een slagaderlijke bloeding spuit het bloed stootsgewijs uit de wond. " +
				"Het bloed uit slagaderen is verder te herkenen aan de helderrode kleur." +
				"\n\nDe slagaderlijke bloeding is erg gevaarlijk en moet snel gestopt worden." +
				"\n\nDat kunt u doen door met uw vingers te duwen op de slagader. " +
				"\n\nProbeer de betreffende slagader dicht te duwen op diens weg tussen het hart en de wond." +
				"Duw de ader dicht op een harde ondergrond. Bv op een bot"+
				"\n\nIndien mogelijk houdt het lichaamsdeel hoog. " +
				"\nBv: 'Een pols boven het hoofd van de pati�nt.'" +
				"\nLeg het slachtoffer op zijn rug en houd druk op de wond." +
				"\n\nVraag een omstander om de ader dicht te drukken."  );
		Ader.setText("\n-Ader:" +
				"\nBij een aderlijke bloeding, stroomt het bloed gelijkmatig uit de wond." +
				"\nDe bloeding kan het best gestopt worden door de wond met behulp van een steriele doek (in de verbanddoos) krachtig dicht te drukken." +
				"\nHoud het verwonde lichaamsdeel zo mogelijk omhoog. " +
				"\nLeg de pati�nt op zijn rug, en houd druk op de wond zolang deze bloedt.");
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){

		case R.id.btSlagAderTerug:
			finish();
		break;
		case R.id.btSlagaderDrukpunten:
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.Drukpunten");
				Intent intentDrie = new Intent(Ader_of_Slagaderlijke_bloeding.this, ourClass3);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentDrie);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		break;
		}//einde switch
		
	}
	
	

}
