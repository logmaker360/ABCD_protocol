package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Stabiele_zijligging extends BaseClassABCD implements OnClickListener {
	ImageView StabieleZijLigging;
	Button  terug;
	float scaleWidth, scaleHeight;
	float zoom = 0.0f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stabielezijligging);
		StabieleZijLigging = (ImageView) findViewById(R.id.ivStabielezijligging);
		StabieleZijLigging.setKeepScreenOn(true);
		terug = (Button) findViewById(R.id.btStabieleZijliggingTerugWaarWeVandaanKwamen);
		terug.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.btStabieleZijliggingTerugWaarWeVandaanKwamen:
			finish();
			break;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
