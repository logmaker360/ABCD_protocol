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

public class Disability extends BaseClassABCD implements OnClickListener{
    TextView bewustzijnNiveau, ambuInfo;
    Button stabieleZijligging;
    ImageView naarExposure;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disability);
		bewustzijnNiveau = (TextView)findViewById(R.id.tvBewustzijnNiveau);
		stabieleZijligging = (Button)findViewById(R.id.btStabieleZijligging);
		naarExposure = (ImageView)findViewById(R.id.ibnaarExposure);
		stabieleZijligging.setOnClickListener(this);
		naarExposure.setOnClickListener(this);
		ambuInfo = (TextView)findViewById(R.id.tvDisabilityAmbiInfo);
		
		bewustzijnNiveau.setText("Probeer het bewustzijn niveau te bepalen." +
				"\n\nEr bestaan 4 niveau's:" +
				"\n\n-Alert: patient is bij bewustzijn, en geeft heldere antwoorden op uw vragen." +
				"\n\n-Verbal: patient is bij bewustzijn, maar maakt een verwarde indruk. " +
				"\n\n-Pain: patient is bewustloos, maar reageert op een pijnprikkel." +
				"\n\n-Unresponsive: pati�nt is bewustloos, maar reageert niet op een pijnprikkel. " +
				"\nPati�nt is in levensgevaar, zijn hersenen reageren niet meer op pijn." + 
				"\n\nPijnprikkel: knijp in de monnikskapspier. Als u niet weet hoe dit moet, sla het dan over." +
				"\n\nAls er geen sprake is van nekletsel, leg dan de bewusteloze patient in de stabiele zijligging"+
				"\n\nStel een Alert persoon gerust, vertel dat hulpdiensten onderweg zijn." +
				"\n\nBlijf praten tegen en Verbal persoon. Probeer zijn aandacht te krijgen / vast te houden." +
				"\n\nAls er geen sprake is van een ongeluk hou dan rekening met mogelijk: " +
				"\n->Medicatie (niet op tijd ingenomen, of teveel / verkeerd)" +
				"\n-> Vergiftigingen(alcohol,drugs)," +
				"\n->Suikerziekte, " +
				"\n->Epilepsie of warmte/koudeletsel." +
				"\n->Er kan ook sprake zijn van een TIA of een beroerte. " +
				"\n\nAls passerende hulpverlener kunt u hier weinig aan doen." );
		ambuInfo.setText("\n\nProbeer erger te voorkomen. \nGa na hoe lang de klachten al bestaan (tijd). \nEn geef dit door aan de ambulancedienst ");
		ambuInfo.setTextColor(Color.RED);
		
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btStabieleZijligging:
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.Stabiele_zijligging");
				Intent intentVier = new Intent(Disability.this, ourClass3);
				intentVier.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentVier);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			break;
		case R.id.ibnaarExposure:
			Class naarExposure;
			try {
				naarExposure = Class.forName("com.first.aid.abcd.Exposure");
				Intent intent = new Intent(Disability.this, naarExposure);
				intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			break;
		}
		
	}
	
}
