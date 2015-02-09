package com.first.aid.abcd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Circulation extends BaseClassABCD implements OnClickListener {
	TextView Capulaire_refill, ShockHouding, NaarDisablity, bloeding, tekstBrandwonden;
	ImageView NaarDisablityD;
	Button slagaderlijkebloeding, brandwonden;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circulation);
		
		Capulaire_refill = (TextView)findViewById(R.id.tvCapilaireRefill);
		ShockHouding = (TextView)findViewById(R.id.tvShockHouding);
		NaarDisablity = (TextView)findViewById(R.id.tvNaarDisablity);
		bloeding = (TextView)findViewById(R.id.tvCirculationBloeding);
		NaarDisablityD =(ImageView)findViewById(R.id.ibnaarDisablity);
		NaarDisablityD.setOnClickListener(this);
		slagaderlijkebloeding = (Button)findViewById(R.id.btCiruclationSlagader);
		slagaderlijkebloeding.setOnClickListener(this);
		brandwonden = (Button)findViewById(R.id.btCiruclationBrandwonden);
		brandwonden.setOnClickListener(this);
		tekstBrandwonden = (TextView)findViewById(R.id.tvCirculationBrandwonden);
		
		bloeding.setText("Zichtbare Bloedingen \n\n" +
				"Controleer of de patient ernstig bloed.\n" +
				"-Slagader, veel bloed stroomt stootsgewijs uit de wond" +
				"\n-Ader het bloed stroomt gelijkmatig uit de wond.");
		
		tekstBrandwonden.setText("Vermoeden van brandwonden? Druk op onderstaande knop.");
		
		Capulaire_refill.setText("Interne bloedingen:\n\n" +
				"-Druk hard op de een vingernagel, zodat die wit wordt. \n" +
				"-Kijk of de nagel binnen 3 seconden terug kleurt." +
				"\n-Heeft de pati�nt koude handen, druk dan hard op het voorhoofd." +
				"\n-Kleurt de nagel of het voorhoofd, niet binnen 3 seconden terug. " +
				"\n-Dan is de pati�nt mogelijk in shock," +
				"\n-Dit kan komen door zware interne bloedingen." +
				"\n-Slachtoffer verkeert in levensgevaar." +
				"\n-Let goed op... " +
				"\nOok pati�nten die gewoon antwoord geven op jouw vragen, kunnen van binnen doodbloeden.");
		ShockHouding.setText    ("-Leg slachtoffer in de Shockhouding, met de benen omhoog.\n" +
				"-Zodat het bloed uit de benen naar de borst en hersenen kan stromen\n" +
				"-Blijf ademhaling controleren totdat de ambulance er is");
		NaarDisablity.setText   ("Geef door aan de verpleger, GEEN CAPILLAIRE REFILL");
		NaarDisablity.setTextColor(Color.RED);
		
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.ibnaarDisablity:
		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.Disability");
			Intent intentVier = new Intent(Circulation.this, ourClass3);
			intentVier.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intentVier);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		
		case R.id.btCiruclationSlagader:
			Class ourClass4;
			try {
				ourClass4 = Class.forName("com.first.aid.abcd.Ader_of_Slagaderlijke_bloeding");
				Intent intentVier = new Intent(Circulation.this, ourClass4);
				intentVier.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentVier);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		case R.id.btCiruclationBrandwonden:
			Class ourClass5;
			try {
				ourClass5 = Class.forName("com.first.aid.abcd.Brandwonden");
				Intent intentVier = new Intent(Circulation.this, ourClass5);
				intentVier.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentVier);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		}//einde switch
		
		
	}
	
}
