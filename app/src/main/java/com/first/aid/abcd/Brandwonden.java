package com.first.aid.abcd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Brandwonden extends BaseClassABCD implements OnClickListener{
TextView brandwonden;
Button terug;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brandwonden);
		brandwonden =(TextView)findViewById(R.id.tvBrandwondeninxmlbrandwonden);
		brandwonden.setText("Eerst water de rest komt later." +
				"\n\nKoel alleen de wond, niet de patient" +
				"\n\nKoel bij voorkeur met lauw water, niet met ijs." +
				"\n\nVerwijder kleding rondom de wond." +
				"\n\nVerwijder geen vastgebrande kleding uit de wond!!!"+
				"\n\nBlijf koelen tot de ambulance het overneemt." +
				"\n\nBij grote brandwonden, pas op dat het slachtoffer niet onderkoelt raakt van het koelwater." +
				"Koel met lauw water, en alleen de wonden." +
				"\n\n Bij een brandwond groter dan een 2 euro stuk. Minimaal 20 minuten koelen."
	);
		terug = (Button)findViewById(R.id.btBrandwondenTerug);
		terug.setOnClickListener(this);
		
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
		
	}
	

}
