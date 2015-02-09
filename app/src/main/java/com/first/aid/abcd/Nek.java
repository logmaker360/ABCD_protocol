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
import android.widget.ImageView;
import android.widget.TextView;

public class Nek extends BaseClassABCD{
	TextView nekklachten, stabaliseer;
    ImageView eersteHulp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nek);
	    nekklachten = (TextView)findViewById(R.id.tvNekKlachten);
	    stabaliseer = (TextView)findViewById(R.id.tvStabaliseer);
	    eersteHulp = (ImageView)findViewById(R.id.ibEersteHulp);
		nekklachten.setText("Is het slachtoffer betrokken geweest bij een ongeval of hard gevallen, " +
				"dan bestaat er kans op nekletsel." +
				"\n\nLet op....\n " +
				"-Staat het hoofd in een onnatuurlijke stand?\n\n" +
				"-Klaagt het slachtoffer over pijn in zn nek?\n\n" +
				"-Schade in de omgeving. Bv slachtoffer zit in een zwaar beschadigde auto." );
		stabaliseer.setText("Zorg ervoor dat zijn hoofd zo min mogelijk beweegt.\n" +
		                    "Stabiliseer de nek met uw handen. \nUw polsen langs het hoofd. Zie afbeelding" +
		                    "\nVraag een omstander om dit te doen, \n\nU kunt dan verder gaan met het onderzoek.\n" +
		                    "druk op de pijl.\n\n");
	    stabaliseer.setTextColor(Color.RED);
		eersteHulp.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Class ourClassNek;
				try {
					ourClassNek = Class.forName("com.first.aid.abcd.BijBewustzijn");
					Intent intentNek = new Intent(Nek.this, ourClassNek);
					intentNek.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(intentNek);	
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
	
	
	
	
	}
	
}
