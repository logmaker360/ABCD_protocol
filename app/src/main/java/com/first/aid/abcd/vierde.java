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
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class vierde extends BaseClassABCD implements OnClickListener {

	ImageView pijlRechts, waarBenIk, belAlarmnummer;
	TextView alarmeren;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vierde);
		pijlRechts = (ImageView) findViewById(R.id.btpijlnaarrechts4);
		waarBenIk = (ImageView) findViewById(R.id.ivWaarBenIk);
		belAlarmnummer = (ImageView) findViewById(R.id.ivBel_112);
		pijlRechts.setOnClickListener(this);
		waarBenIk.setOnClickListener(this);
		belAlarmnummer.setOnClickListener(this);

		alarmeren = (TextView) findViewById(R.id.tvAlarmeren);
		alarmeren
				.setText("Bel het Alarmnummer 112, geef door.... "
						+ "\n\n->wat er is gebeurd. "
						+ "\n->waar (adres). "
						+ "\n-> hoeveel slachtoffers u ziet."
						+ "\n\nUw kunt ook een omstander laten bellen! "
						+ "\nInstrueer in dat geval de beller, om bij u terug te komen."
						+ "\nOm er zeker van te zijn dat contact met de meldkamer is gelukt."
						+ "\n\nStuur een omstander naar de weg, om de hulpdiensten optevangen. "
						+ "\n\nDruk op de afbeelding voor...");

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btpijlnaarrechts4:
			Toast toast = Toast
					.makeText(this, "werkt dit?", Toast.LENGTH_SHORT);
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.vijfde");
				Intent intentDrie = new Intent(vierde.this, ourClass3);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentDrie);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case R.id.ivWaarBenIk:
			// naar activity Waarschuwing voor Waarbenik
			Class ourClass4;
			try {
				ourClass4 = Class
						.forName("com.first.aid.abcd.Waarschuwing_voor_WaarBenIk");
				Intent intentVier = new Intent(vierde.this, ourClass4);
				intentVier.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentVier);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case R.id.ivBel_112:
			// bel nummer 112
			boolean isOk = true;
			Intent intent = new Intent();

			if (!deviceIsAPhone()) {
				displayAlert();
				isOk = false;
			}
			if (isOk) {
				intent.setAction(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:112"));
				startActivity(intent);
			}
			break;
		}
	}

	private void displayAlert() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
		alertBuilder.setTitle("Dit is geen telefoon")
				.setMessage("Dit toestel kan niet bellen")
				.setPositiveButton("OK", new myDialogListener()).show();
	}

	class myDialogListener implements DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int whichButton) {

		}

	}

	private boolean deviceIsAPhone() {
		// TODO Auto-generated method stub
		TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		return manager.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
	}

	
}
