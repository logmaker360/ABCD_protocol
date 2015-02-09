package com.first.aid.abcd;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Naar_begin extends BaseClassABCD {
	
	Intent intent = new Intent();
    Button afsluiten ,terug;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
			Class ourClass3;
			try {
				ourClass3 = Class.forName("com.first.aid.abcd.Eerste");
				Intent intentDrie = new Intent(Naar_begin.this, ourClass3);
				intentDrie.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentDrie);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
}
