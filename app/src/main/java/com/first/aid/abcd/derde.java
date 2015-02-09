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

public class derde extends BaseClassABCD implements OnClickListener {
	/** Called when the activity is first created. */
	ImageView pijlRechts;
	TextView markeren;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.derde);
		pijlRechts =(ImageView) findViewById(R.id.btPijlNaarRechts3);
		pijlRechts.setOnClickListener(this);
		markeren=(TextView)  findViewById(R.id.tvMarkeren);
		markeren.setText("Markeer of elimineer acute gevaren. " +
				"\n\nVerwijder of markeer gevaarlijke elementen. " +
				"\n\nZet bijvoorbeeld wegen af. " +
				"\n\nVraag omstanders om hierbij te helpen!  ");

	}

	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btPijlNaarRechts3:
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.vierde");
				Intent intentDrie = new Intent(derde.this, ourClass3);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intentDrie);	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
			break;
		}

	}

    
}