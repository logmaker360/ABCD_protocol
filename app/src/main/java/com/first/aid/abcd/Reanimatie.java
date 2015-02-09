package com.first.aid.abcd;

import java.io.IOException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;  
import android.view.MenuInflater;
import android.view.MenuItem;

public class Reanimatie extends BaseClassABCD implements  android.view.View.OnClickListener{
      
	TextView Houding, Beademen, Klaarmaken, Ritme;
	Button ReanimatieRitme, StopReanimatieRime, Terug;
	boolean Beveiliging = false;
    MediaPlayer piep ;
    int explosion = 0;
    
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reanimatie);
		
		
		
		Houding =(TextView)findViewById(R.id.tvHoudingReanimatie);
		Beademen = (TextView)findViewById(R.id.tvBeademen);
		Klaarmaken = (TextView)findViewById(R.id.tvVerwijderJas);
		Ritme = (TextView)findViewById(R.id.tvRitmeAantal);
		ReanimatieRitme = (Button)findViewById(R.id.btRitmeReanimatie);
		StopReanimatieRime = (Button)findViewById(R.id.btStopReanimatie);
		Terug = (Button)findViewById(R.id.btTerugNaarBreating);
		Terug.setOnClickListener(this);
		ReanimatieRitme.setOnClickListener(this);
		ReanimatieRitme.setKeepScreenOn(true); // zet het scherm aan
		StopReanimatieRime.setOnClickListener(this);
		
		Klaarmaken.setText("-Rits jas open\n " +
				"-Indien mogelijk knip trui/blouse/tShirt open\n" +
				"-Ga op uw knieen naast het slachtoffer zitten." );
		Houding.setText("-Kruis vingers in elkaar(zie foto)\n " +
				"-Plaats handen op het midden van de borst, boven het middenrif.");
        Ritme.setText("\n-Druk op de knop Start Ritme \n" +
        		"-Houdt ellebogen gestrekt, druk vanuit uw bovenlichaam/borst.\n" +
        		"-Druk de borst van het slachtoffer 6 cm in\n " +
        		"-Druk de borst in op het ritme van de Piep.");
        Beademen.setText("Op aanwijzing van de App, \n" +
        		"-Als de piep stopt,(na 30 keer) beadem. \n" +
        		"-Stop reanimeren\n" +
        		"-Open de mond door de kin op te tillen\n" +
        		"-Knijp met de andere hand zijn neus dicht.\n" +
        		"-Mond op mond, en adem krachtig uit.\n" +
        		"-2 keer beademen. na 8 seconden begint het ritme vanzelf opnieuw." +
        		"\n\n-Blijf reanimeren totdat de ambulance het overneemt.");
        
        piep = MediaPlayer.create(Reanimatie.this, R.raw.dertigkeerplustienpauze);
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btRitmeReanimatie:
			Beveiliging = true;
			try{
				piep.prepare();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			
			piep.setLooping(true);
			piep.start();
			break;
			
		case R.id.btStopReanimatie:
			//piep.stop();
			//piep.setLooping(false);
			piep.pause();
			Beveiliging = false;	
			break;
		case R.id.btTerugNaarBreating:
			piep.stop();
			System.exit(0);
				Class ourClass3;
				try {
					ourClass3 = Class.forName("com.first.aid.abcd.Breating");
					Intent intentDrie = new Intent(Reanimatie.this, ourClass3);
					startActivity(intentDrie);
			        		
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

	}
	
	
			
	
}

