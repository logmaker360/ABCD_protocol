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
import android.widget.ImageView;
import android.widget.TextView;

public class Breating extends BaseClassABCD implements OnClickListener {
	TextView Ademt, Tellen, Uitkomst;
	Button Reanimatie, StartTijd, naarHyperventilatie;
	int uitkomstaantalademhalingen = 1000;
	ImageView naarCirculation;
	Bundle mand = new Bundle();
	
	//1000 is een overrulend getal dit zorg er voor dat hij keurig wacht totdat hij een waarde krijgt van StartActivityForResult

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.breating);

		Ademt = (TextView) findViewById(R.id.tvAdem);
		Tellen = (TextView) findViewById(R.id.tvTellen);
		Uitkomst = (TextView) findViewById(R.id.tvUitkomst);
		Uitkomst.setTextColor(Color.RED);
		Reanimatie = (Button) findViewById(R.id.btReanimatie);
		StartTijd = (Button) findViewById(R.id.btStartTijd);
		StartTijd.setOnClickListener(this);
		Reanimatie.setOnClickListener(this);
		Reanimatie.setVisibility(View.INVISIBLE);
		naarCirculation = (ImageView)findViewById(R.id.ibnaarcirculation);
		naarCirculation.setOnClickListener(this);
		naarCirculation.setVisibility(View.INVISIBLE);
		naarHyperventilatie = (Button)findViewById(R.id.btBreatingNaarHyperventilatie);
		naarHyperventilatie.setOnClickListener(this);
		naarHyperventilatie.setVisibility(View.INVISIBLE);
		

		Ademt.setText("Leg een bewusteloze pati�nt op zijn rug. " +
				"\n\nKijken, Luisteren, Voelen:" +
				"\n\n-Kijk of zijn Borst omhoog komt. \n"
				+ "-Luister naar zijn ademhaling. \n"
				+ "-Voel(met je gezicht) of hij uitblaast. " +
				"\n\nHet kan zijn dat de patient amper ademt," +
				" \nzeer onregelmatig ademt, of erg luidruchtig naar lucht hapt. " +
				"Dit kan wijzen op een teken van circulatiestilstand");
		Tellen.setText("Druk op onderstaande knop om 30 seconden lang de ademhaling te tellen. " );
		Uitkomst.setText("Na 30 seconde tellen, selecteerd deze app automatische een vervolgmenu. ");

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ibnaarcirculation:
				Class ourClass3;
				try {
					ourClass3 = Class.forName("com.first.aid.abcd.Circulation");
					Intent intentDrie = new Intent(Breating.this, ourClass3);
					intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(intentDrie);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		break;
		
		case R.id.btBreatingNaarHyperventilatie:
			Class ourClass7;
			try {
				ourClass7 = Class.forName("com.first.aid.abcd.Hyperventilatie");
				Intent intentZeven = new Intent(Breating.this, ourClass7);
				intentZeven.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentZeven);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		case R.id.btStartTijd:

			Intent ademIntent = new Intent(Breating.this, AdemRegestratie.class);
			startActivityForResult(ademIntent, 0);


		break;
		case R.id.btReanimatie:
			Class ourClassReanimatie;
			try {
				ourClassReanimatie = Class
						.forName("com.first.aid.abcd.Reanimatie");
				Intent intentReanimatie = new Intent(Breating.this,
						ourClassReanimatie);
				intentReanimatie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentReanimatie);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		if (resultCode == RESULT_OK) {
			Bundle basket = data.getExtras();
			uitkomstaantalademhalingen = basket.getInt("key");
			if ((uitkomstaantalademhalingen * 2) < 9) {
				Uitkomst.setText("Slachtoffer heeft "
						+ uitkomstaantalademhalingen * 2
						+ " ademhalingen per minuut.\n"
						+ "Dit is te weinig.\n Start reanimatie");
				Reanimatie.setVisibility(View.VISIBLE);
				naarCirculation.setVisibility(View.INVISIBLE);
				naarHyperventilatie.setVisibility(View.INVISIBLE);
				Class ourClassNaarReanimatie;
				try { 
					mand.putInt("sleutel", uitkomstaantalademhalingen * 2);
					ourClassNaarReanimatie = Class
							.forName("com.first.aid.abcd.TussenResultaatNaarReanimatieToe");
					Intent intentNaarReanimatie = new Intent(Breating.this,
							ourClassNaarReanimatie);
					intentNaarReanimatie.putExtras(mand);
					intentNaarReanimatie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					startActivity(intentNaarReanimatie);
				} catch (ClassNotFoundException e) { // TODO Auto-generated
														// catch block
					e.printStackTrace();
				}
		
			} else if (((uitkomstaantalademhalingen * 2) > 9)
					&& ((uitkomstaantalademhalingen * 2) < 24)) {
				Uitkomst.setText("Er zijn " + uitkomstaantalademhalingen * 2 + " ademhalingen per minuut gemeten \nGa verder met het onderzoek.");
				naarCirculation.setVisibility(View.VISIBLE);
				Reanimatie.setVisibility(View.INVISIBLE);
				naarHyperventilatie.setVisibility(View.INVISIBLE);
				Class ourClassNaarCirculatie;
				try { 
					mand.putInt("sleutel", uitkomstaantalademhalingen * 2);
					ourClassNaarCirculatie = Class
							.forName("com.first.aid.abcd.BreatingResultaatNaarCirculation");
					Intent intentNaarCirculation = new Intent(Breating.this,
							ourClassNaarCirculatie);
					intentNaarCirculation.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					intentNaarCirculation.putExtras(mand);
					startActivity(intentNaarCirculation);
				} catch (ClassNotFoundException e) { // TODO Auto-generated
														// catch block
					e.printStackTrace();
				}
				
		    
			} else if ((uitkomstaantalademhalingen * 2) > 23) 
			         {
				Uitkomst.setText("Er zijn " + uitkomstaantalademhalingen * 2 +
						" ademhalingen per minuut gemeten\nSlachtoffer is waarschijnlijk aan het hyperventileren.");
				naarHyperventilatie.setVisibility(View.VISIBLE);
				Reanimatie.setVisibility(View.INVISIBLE);
				naarCirculation.setVisibility(View.INVISIBLE);
				Class ourClassNaarHyperventilatie;
				try { 
					mand.putInt("sleutel", uitkomstaantalademhalingen * 2);
					ourClassNaarHyperventilatie = Class
							.forName("com.first.aid.abcd.BreatingResultaatnaarHyperventilatie");
					Intent intentNaarHyperventilatie = new Intent(Breating.this,
							ourClassNaarHyperventilatie);
					intentNaarHyperventilatie.putExtras(mand);
					intentNaarHyperventilatie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					startActivity(intentNaarHyperventilatie);
				} catch (ClassNotFoundException e) { // TODO Auto-generated
														// catch block
					e.printStackTrace();
				}
			}

		}
	}

	

	
}
