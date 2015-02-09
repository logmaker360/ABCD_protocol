package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tweede extends BaseClassABCD implements OnClickListener {
	ImageView pijlRechts;
	
	TextView anderMansVeiligheid;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweede);
        pijlRechts =(ImageView) findViewById(R.id.btPijlNaarRechts2);
		pijlRechts.setOnClickListener(this);
     
      anderMansVeiligheid=(TextView)findViewById(R.id.andermansVeiligheid);
      anderMansVeiligheid.setText("Maak omstanders alert op de gevaarlijke situatie." +
      		"\n\nVoorkom dat er meer slachtoffers vallen. ");
  
        
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btPijlNaarRechts2:
			Toast toast = Toast
					.makeText(this, "werkt dit?", Toast.LENGTH_SHORT);
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.derde");
				Intent intentDrie = new Intent(tweede.this, ourClass3);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentDrie);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
			break;
		}
		
	}
    
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
	}
}