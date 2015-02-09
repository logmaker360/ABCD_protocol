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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Verslikking extends BaseClassABCD {
     
	TextView Schouderklop, Heimrich, babyklop, naarBreating; 
	ImageView ibNaarBreating;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.verslikking);
	    Schouderklop =(TextView)findViewById(R.id.tvSchouderklop);
	    Heimrich =(TextView)findViewById(R.id.tvHeimrich);
	    babyklop =(TextView)findViewById(R.id.tvbabyklop);
	    naarBreating =(TextView)findViewById(R.id.tvNaarBreating);
	    ibNaarBreating =(ImageView)findViewById(R.id.ibNaarBreating);
	
	Schouderklop.setText("Controleer of de ademweg van de patient niet wordt belemmerd." +
	        "\nLet op hoesten en/of benauwde lichaamstaal." +
			"\nBij verslikking zit er iets in de luchtpijp wat er uit moet!" +
			"\n\n-Ga achter de patient staan." +
			"\n-Duw zijn hoofd iets voorover.\n" +
			"-Sla 5 keer krachtig tussen zijn schouderbladen.\n" +
			"\n-Vertel wat je gaat doen.\n" +
			"\n-Helpt dit niet, klop dan nogmaals 5 keer krachtig." +
			"\n-Herhaal dit indien nodig nog 2 maal.\n\n");
	
	Heimrich.setText("Heeft bovenstaande niet geholpen, probeer dan het volgende." +
			"\n-Blijf achter het slachtoffer staan." +
			"\n-Plaats u rechter vuist onder zijn middenrif." +
			"\n-Leg linker hand op uw rechter vuist." +
			"\n-Zet uzelf schrap." +
			"\n-Trek krachtig uw vuist naar achteren." +
			"\n-Vertel wat u doet." +
			"\n-Zie afbeelding");
	
	Heimrich.setTextColor(Color.RED);
	babyklop.setText("Bij een klein kind of baby." +
			"\n-Hou het kind op zijn kop, met het hoofd naar beneden." +
			"\n-Sla niet te hard");
	naarBreating.setText("Is de luchtpijp vrij ga dan door met de volgende controlle. " +
			"\nDruk op de pijl.");
	
	
	ibNaarBreating.setOnClickListener(new View.OnClickListener() {
    	
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Class ourClassVBreating;
			try {
				ourClassVBreating = Class.forName("com.first.aid.abcd.BewustAdem");
				Intent intentVBreating = new Intent(Verslikking.this, ourClassVBreating);
				startActivity(intentVBreating);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	}

	
	
}
