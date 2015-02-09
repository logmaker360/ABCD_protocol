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

public class eersteHulp extends BaseClassABCD{
 TextView airway, chinlift, jawtrust, verder; 
 ImageView Breating;
 //Button verslikking;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.eerstehulp);
	    
	    airway = (TextView)findViewById(R.id.tvAirway);
	    chinlift = (TextView)findViewById(R.id.tvChinlift);
	   // jawtrust = (TextView)findViewById(R.id.tvJawtrust);
	    //verslikking = (Button)findViewById(R.id.btVerslikking);
	    Breating = (ImageView)findViewById(R.id.ibBreating);
	    verder = (TextView)findViewById(R.id.tvVerder); 
	  	    
	    airway.setText("Bij een bewusteloos patient...\nControleer of de luchtweg vrij is. " +
	    		"\nVerwijder eventueel: 'slijm, braaksel, bloed' uit de mond." +
	    		"\n\nHieronder staan twee manieren om de mond open te krijgen");
	    airway.setTextColor(Color.RED);
	    chinlift.setText("Kijk in de mond. ");
	   // jawtrust.setText("heeft de persoon zich verslikt, en hierdoor erg benauwd?" +
	    //		"\nklik op 'verslikking' knop");
	    verder.setText("\nIs de luchtweg vrij, klik op de pijl\n");
	    
	     
	    Breating.setOnClickListener(new View.OnClickListener() {
	    	
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Class ourClassBreating;
				try {
					ourClassBreating = Class.forName("com.first.aid.abcd.Breating");
					Intent intentBreating = new Intent(eersteHulp.this, ourClassBreating);
					intentBreating.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(intentBreating);	
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
}
