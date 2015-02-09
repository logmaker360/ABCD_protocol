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
import android.widget.TextView;

public class Exposure extends BaseClassABCD implements OnClickListener{
    TextView beschrijving, amblance, naarMenu, naarOpnieuwABCD;
	Button menu, opnieuwABCD;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exposure);
		naarMenu = (TextView)findViewById(R.id.tvExposureMeerInfo);
		naarOpnieuwABCD = (TextView)findViewById(R.id.tvUitlegOpnieuwABCDExposure);
		amblance = (TextView)findViewById(R.id.tvExposureAmbulance);
		amblance.setTextColor(Color.RED);
		beschrijving = (TextView)findViewById(R.id.tvExposure);
		beschrijving.setText("Haal de patient uit de elementen. " +
				"\nuit de wind, zon, regen, kou." +
				"\nGeef natte pati�nten drogen kleding, of een deken. " +
				"\n\nVoor verder onderzoek kunt u de afkorting SAMPLE gebruiken." +
				"\n\nSymptomen: \n-Waar heeft u pijn? \n-Hoe erg is de pijn? \n-Heeft u nog andere klachten?� " +
				"\n\nAllergie: \n-Bent u ergens allergisch voor?" +
				"\n\nMedicijnen \n-Gebruikt u medicijnen?" +
				"\n\nPast Illness/History: \n-Heeft u een ziekte? \n-Of in het verleden een ziekte gehad?�" +
				"\n\nLast Meal: \n-Wanneer heeft u voor het laatst gegeten / gedronken?" +
				"\n\n-Wat heeft u gegeten of gedronken?" +
				"\n\n-�Heeft u alcohol of drugs gebruikt? " +
				"\n\nEvents/Environment: \n-Wat is er voorafgaand aan het ongeval gebeurd? " +
				"\n-Wat was het slachtoffer aan het doen voordat hij onwel werd? " );
	amblance.setText("\n\nInformatie die hieruit komt kan nuttig zijn voor de ambulancedienst.");
	naarOpnieuwABCD.setText("\nHerhaal ABCD totdat de ambulance het van u overneemt." +
			"Weet u niet meer hoe u moet handelen? " +
			"\nBlijf rustig. " +
			"\nBel nogmaals 112 en leg hun het probleem voor. " +
			"\nZij kunnen u telefonisch bijstaan.");
	naarMenu.setText("Voor meer informatie, of snelle links druk op: Menu.");
	menu = (Button) findViewById(R.id.btnaarMenuEinde);
	menu.setOnClickListener(this);
	opnieuwABCD = (Button)findViewById(R.id.btopnieuwABCDExposure);
	opnieuwABCD.setOnClickListener(this);
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnaarMenuEinde:
		
		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.Menu");
			Intent intentDrie = new Intent(Exposure.this, ourClass3);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		case R.id.btopnieuwABCDExposure:
			Class ourClass4;
			try {
				ourClass4 = Class.forName("com.first.aid.abcd.BijBewustzijn");
				Intent intentVier = new Intent(Exposure.this, ourClass4);
				intentVier.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentVier);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
	}
	
	

}
