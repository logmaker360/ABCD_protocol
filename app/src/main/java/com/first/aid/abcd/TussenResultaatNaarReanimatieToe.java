package com.first.aid.abcd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TussenResultaatNaarReanimatieToe extends BaseClassABCD implements
		OnClickListener {
	Button naarReanimatie;
	TextView resultaat;
	int aantalAdemhalingen;
	Bundle getMand;
	ImageView bel112;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tussenresultaatnaarreanimatietoe);
		getMand = getIntent().getExtras();
		aantalAdemhalingen = getMand.getInt("sleutel");
		naarReanimatie = (Button) findViewById(R.id.btNaarReanimatie);
		naarReanimatie.setOnClickListener(this);
		resultaat = (TextView) findViewById(R.id.tvTussenResultaatReanimatie);
		bel112 = (ImageView) findViewById(R.id.ivTussenResulataatNaarReanimatieToeBel112);
		bel112.setOnClickListener(this);
		bel112.setKeepScreenOn(true);
		resultaat
				.setText("Er zijn\n "
						+ aantalAdemhalingen
						+ " ademhalingen gemeten." +
						"\n\nDit is te weinig, ga over op reanimatie."
						+ "\n\nVoordat u begint bel 112, geef door dat u gaat reanimeren. \n"
						+ "\nDit is heel belangrijk...\nBij een Reanimatie stuurt de meldkamer meerdere  ziekenauto's"
						+ "\n\nVraag een omstander om 112 te bellen, en laat hem doorgeven 'slachtoffer met reanimatie'."
						+ "\n\nOf druk op de groene telefoonhoorn om 112 te bellen." +
						"\n\nHeeft u geen ervaring met Reanimatie, dan kan de meldkamer u telefoonische bijstaan.");

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btNaarReanimatie:
			Class ourClassNaarReanimatie;
			try {
				ourClassNaarReanimatie = Class
						.forName("com.first.aid.abcd.Reanimatie");
				Intent intentNaarReanimatie = new Intent(
						TussenResultaatNaarReanimatieToe.this,
						ourClassNaarReanimatie);
				intentNaarReanimatie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intentNaarReanimatie);
			} catch (ClassNotFoundException e) { // TODO Auto-generated
													// catch block
				e.printStackTrace();

			}
			break;
		case R.id.ivTussenResulataatNaarReanimatieToeBel112:
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
