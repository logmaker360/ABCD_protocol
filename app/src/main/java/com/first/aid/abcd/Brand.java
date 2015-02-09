package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Brand extends BaseClassABCD implements OnClickListener{
TextView brandAirway, brandWonden;
Button bijwustzijn, bewustloos;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brand);
		brandAirway = (TextView)findViewById(R.id.tvBrandAirway);
		brandAirway.setText("Is het slachtoffer bij brand betrokken geweest. " +
				"Dan heeft het slachtoffer mogelijk rook ingeademt. " +
				"\n\nTekenen hiervan zijn:" +
				"\n->Brandwonden in het gezicht." +
				"\n->Verbranding rondom de nek " +
				"\n->Verbranding van de neusharen en/of wenkbrauwen " +
				"\n->Roet rond de neusgaten of rond de mond" +
				"\n->Blaren in de mond " +
				"\n->Hoesten, viezig slijm, ophoesten van roetdeeltjes" +
				"\n->Heesheid, hese stem" +
				"\n->Gierende ademhaling" +
				"\n\nRookgassen zijn giftig en vaak heet. " +
				"De luchtpijp kan (ook na verloop van tijd) door blaarvorming worden dichtgedrukt." +
				"\n\nPatient heeft zuurstof nodig. Zorg dat hij in de frisse lucht zit." +
				" Maak indien mogelijk de mond schoon." +
				"\n\nVertel de ambulanceverpleegkundige dat de patient rook heeft ingeademt.(inhalatietrauma)"
			);
				
		brandWonden = (TextView)findViewById(R.id.tvBrandWonden);
		brandWonden.setText("\n\n Ga verder." +
				"\n\n Slachtoffer is...");
		bijwustzijn = (Button)findViewById(R.id.btBrandBijBewustzijn);
		bijwustzijn.setOnClickListener(this);
		bewustloos = (Button)findViewById(R.id.btBrandBewustloos);
		bewustloos.setOnClickListener(this);
		
		
	}
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch(v.getId()){
	case R.id.btBrandBijBewustzijn:
		Class naarbewustAdem;
		try {
			naarbewustAdem = Class.forName("com.first.aid.abcd.BewustAdem");
			Intent intentDrie = new Intent(Brand.this, naarbewustAdem);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	case R.id.btBrandBewustloos:
		Class naareersteHulp;
	try {
		naareersteHulp = Class.forName("com.first.aid.abcd.eersteHulp");
		Intent intentDrie = new Intent(Brand.this, naareersteHulp);
		intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(intentDrie);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		break;
	}//einde switch
	
}
	

}
