package com.first.aid.abcd;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AdemRegestratie extends Activity implements OnClickListener{
	Button aantalAdemhalingen;
	ImageView plusKnop;
	ProgressBar dertigSeconden;
	TextView secondeTeGaan, aantal;
	int aantalademhalingen = 0;
	int procesEenKeer = 0;
	float test = 5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ademregestratie);
		aantalAdemhalingen = (Button)findViewById(R.id.btademFrequentie);
		aantalAdemhalingen.setText("Start");
		plusKnop = (ImageView)findViewById(R.id.ivademFrequentie);
		dertigSeconden = (ProgressBar)findViewById(R.id.pbademFrequentie);
		secondeTeGaan = (TextView)findViewById(R.id.tvademFrequentie);
		secondeTeGaan.setTextColor(Color.RED);
		aantal = (TextView)findViewById(R.id.tvaantalademFrequentie);
		aantalAdemhalingen.setOnClickListener(this);
		aantalAdemhalingen.setKeepScreenOn(true);
		plusKnop.setOnClickListener(this);
		plusKnop.setVisibility(View.INVISIBLE);//de plus knop wordt onzichtbaar gemaakt om te voorkomen dat hij wordt gebruikt 
		//voordat de tijd is gestart.
		aantal.setTextColor(Color.BLUE);
		aantal.setText("aantal ademhalingen is 0");
		secondeTeGaan.setText("Druk op bovenstaande knop, als u klaar bent om de ademhaling te tellen." +
				"\nNadat u de knop hebt ingedrukt, verschijnt er een groene plus in het scherm. " +
				"\nDruk bij iedere ademhaling 1 keer op die plus.");
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btademFrequentie:
			procesEenKeer++;
			plusKnop.setVisibility(View.VISIBLE);
			if (procesEenKeer == 1) {// dit beveiligd het opstarten van de
												// countdown.
						// Door het aan 1 te koppelen kan het de timer maar een keer
						// worden gestart.
						// dertigseconden.setProgress(100);
						//wL.acquire();// zet het scherm aan
						//AdemhalingPlusEen.setVisibility(View.VISIBLE);
						final int totalMsecs = 30 * 1000; // 30 seconds in milli seconden
						int callInterval = 100;
						/** CountDownTimer */
						new CountDownTimer(totalMsecs, callInterval) {
							public void onTick(long millisUntilFinished) {
								int secondsRemaining = (int) millisUntilFinished / 1000;
								float fraction = millisUntilFinished
										/ (float) totalMsecs;
								// progress bar is based on scale of 1 to 100;
								dertigSeconden.setProgress((int) (fraction * 100));
								secondeTeGaan.setText("seconden te gaan: "
										+ millisUntilFinished / 1000);
							    test = (millisUntilFinished / 1000); 
								//test zorgt ervoor dat het resultaat wordt terug gegeven als de progressbar op nul staat
							   
							    if(test==0){
							    	Bundle basket = new Bundle();
							    	basket.putInt("key", aantalademhalingen);
							    	
							    Intent intent = new Intent();
								intent.putExtras(basket);
								
								setResult(RESULT_OK, intent);
								finish();
								//sluit alles af en de intent met putExtras neemt het resultaat mee.
							    }
							  
							}
						
						
							@Override
							public void onFinish() {
								// TODO Auto-generated method stub
							
							}
						
					}.start();
//					test = 5;
			}
			
			break;
			
		case R.id.ivademFrequentie:
			aantalademhalingen++;
			aantal.setText("Het aantal ademhalingen is " + aantalademhalingen);
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
