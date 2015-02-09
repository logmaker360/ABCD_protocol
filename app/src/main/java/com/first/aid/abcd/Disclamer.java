package com.first.aid.abcd;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Disclamer extends BaseClassABCD{
TextView tekst;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disclamer);
		tekst = (TextView)findViewById(R.id.tvdisclamer);
		tekst.setText("Let op deze applicatie is een stukje gereedschap, een protocol, een hulpmiddel." +
				" Gebaseerd op jarenlange medische kennis en ervaring." +
				" Omdat iedere situatie anders is... " +
				"\n\nKan de maker van deze applicatie nooit verantwoordelijk worden gehouden voor foute afloop." +
				"\n\nNeemt de maker geen enkele juridische verantwoordelijkheid." +
				"\n\n Gebruik altijd uw gezonde verstand. Gebruik het als een hulpmiddel, niet als de ultieme waarheid.");
	}
	

}
