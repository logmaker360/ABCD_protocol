package com.first.aid.abcd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;




public class vijfde extends BaseClassABCD{
	
ImageView knop5;
TextView noodTransport, brandweergreep;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.vijfde);
   
  knop5 = (ImageView)findViewById(R.id.btpijlNaarRechts5);
  noodTransport=(TextView)findViewById(R.id.tvnoodTransport);
  noodTransport.setText("Indien mogelijk verplaats slachtoffers uit de gevarenzone. " +
  		"\n\nDenk aan uw eigen veiligheid." +
  		"\n\nNeem geen grote risico's. \n\nVraag omstanders om hulp bij het verplaatsen." +
  		"\n\nIs het te gevaarlijk, \nNeem dan afstand. En wacht tot de brandweer er is.");
  knop5.setOnClickListener(new View.OnClickListener() {
	
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Class ourClass5;
			try {
				ourClass5 = Class.forName("com.first.aid.abcd.Nek");
				Intent intentVijf = new Intent(vijfde.this, ourClass5);
				intentVijf.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentVijf);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}); 
}

}