package com.first.aid.abcd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Eerste extends BaseClassABCD implements OnClickListener {
	/** Called when the activity is first created. */
	ImageView pijlRechts;
	TextView eigenVeiligheid, link;
    View v;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		pijlRechts =(ImageView) findViewById(R.id.btPijlNaarRechts);
		pijlRechts.setOnClickListener(this);
		eigenVeiligheid = (TextView)findViewById(R.id.tvEigenVeiligheid);
        eigenVeiligheid.setText("Denk om uw eigen veiligheid. " +
        		"\n\nNeem het incident goed in u op." + 
        		"\n\nIs het veilig om hulp te verlenen? " +
        		"\n\nRaak niet in paniek." +
        		"\n\nBedenk dat hulpdiensten snel zullen arriveren. " +
        		"\n\nDruk op de pijl om verder te gaan."
                );

        String titel = "nieuwe applicatie";
        String message = "download nu de nieuw EHBO app uit de Google Play store.";
        showDialog(this, titel, message);
	}

	// public void naarVolgende(View v){
    public void link(View v){
       // Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.aid.first.mb.firstaid&hl=nl"));
       // startActivity(browserIntent);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        String shareBody = "https://play.google.com/store/apps/details?id=com.aid.first.mb.firstaid&hl=nl";
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

	// }
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btPijlNaarRechts:
			Toast toast = Toast
					.makeText(this, "werkt dit?", Toast.LENGTH_SHORT);
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.tweede");
				Intent intentDrie = new Intent(Eerste.this, ourClass3);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentDrie);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
			break;
		}

	}

    public void showDialog(Activity activity, String title, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (title != null) builder.setTitle(title);

        builder.setMessage(message);
        builder.setPositiveButton("Gelezen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
                builder.setNegativeButton("Downloaden", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        link(v);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
