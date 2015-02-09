package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Herhaal_ABCD extends BaseClassABCD {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.BijBewustzijn");
			Intent intentDrie = new Intent(Herhaal_ABCD.this, ourClass3);
			intentDrie.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentDrie);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
