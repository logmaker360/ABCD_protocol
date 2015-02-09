package com.first.aid.abcd;


	import android.content.Context;
import android.content.DialogInterface;
    import android.content.Intent;

	import java.io.IOException;
	import java.util.List;
	import java.util.Locale;

	import android.app.Activity;
import android.app.AlertDialog;
	import android.location.Address;
	import android.location.Geocoder;
	import android.location.Location;
	import android.location.LocationListener;
	import android.location.LocationManager;
import android.net.Uri;
	import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.telephony.TelephonyManager;
	import android.view.MenuItem;
	import android.view.View;
	import android.view.View.OnClickListener;
	import android.widget.Button;
import android.widget.ImageView;
	import android.widget.TextView;
import android.widget.Toast;

	
	public class Locatie extends BaseClassABCD implements OnClickListener {
		ImageView belAlarmnummer;
		TextView myLatitude, myLongitude, myAddress;
		Button Terug;
		LocationManager mlocManager;
		LocationListener mlocListener;
		
		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.locatie);
			
			 myLatitude = (TextView)findViewById(R.id.mylatitude);
			 myLongitude = (TextView)findViewById(R.id.mylongitude);
			 myAddress = (TextView)findViewById(R.id.myaddress);
			 Terug = (Button)findViewById(R.id.btTerug);
			 Terug.setKeepScreenOn(true);
			 belAlarmnummer =(ImageView)findViewById(R.id.ivLocBelAlarmnummer);
			 belAlarmnummer.setOnClickListener(this);
			/* Use the LocationManager class to obtain GPS locations */ 

			mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
			mlocListener = new MyLocationListener(); 
            

			mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener); 
            Terug.setOnClickListener(this);
      
		}
		
		
		

	public class MyLocationListener implements LocationListener{ 
				
				public void onLocationChanged(Location loc) 
			    { 
	            loc.getLatitude(); 
	            loc.getLongitude(); 
 
	        myLatitude.setText("Breedtegraad: " + String.valueOf((float)Math.round(loc.getLatitude() * 1000000) / 1000000));
			myLongitude.setText("Lengtegraad: " + String.valueOf((float)Math.round(loc.getLongitude()* 1000000) / 1000000));
			
			Geocoder geocoder = new Geocoder(Locatie.this.getApplicationContext(), Locale.getDefault());
			try {  List<Address> addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 2);
		    	     if(addresses != null) {
				          Address returnedAddress = addresses.get(0);
				          StringBuilder strReturnedAddress = new StringBuilder("Address:\n");
				          for(int i=0; i<returnedAddress.getMaxAddressLineIndex();i++) {
					             strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
					      }
				          myAddress.setText(strReturnedAddress.toString());
				}
			    else{
			    	myAddress.setText("No Address returned!");
			        }
	     		  }
			catch (IOException e) {
				// TODO Auto-generated catch block  
				e.printStackTrace();
		//dit is fout, onderstaande teks moet worden weergegeven als device offline is.
				myAddress.setText("Kan het adres niet vinden!\n Geef aan de meldkamer door:\n" +
						"Breedtegraad: " + (float)Math.round(loc.getLatitude() * 1000000) / 1000000 + "\n"
					  + "Lengtegraad: "  + (float)Math.round(loc.getLongitude() * 1000000) / 1000000);
				}

			
			    }
			 


			public void onProviderDisabled(String provider) 
			{ 
			Toast.makeText( getApplicationContext(), "GPS staat uit. Zet GPS aan.", Toast.LENGTH_SHORT ).show(); 
			} 


			public void onProviderEnabled(String provider) 
			{ 
			Toast.makeText(getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show(); 
			} 


			public void onStatusChanged(String provider, int status, Bundle extras) 
			{ 
            } 

			} /* End of Class MyLocationListener */






	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btTerug:
		Terug.setKeepScreenOn(false);
		Class ourClass3;
		try {
			ourClass3 = Class.forName("com.first.aid.abcd.vierde");
			Intent intentDrie = new Intent(Locatie.this, ourClass3);
			startActivity(intentDrie);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		case R.id.ivLocBelAlarmnummer:
			//tel alarmnummer;
			boolean isOk = true;
			Intent intent = new Intent();
			
			if(!deviceIsAPhone()){
				displayAlert();
				isOk = false;	
			}
			if (isOk){
				intent.setAction(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:112" ));
				startActivity(intent);
			}
		break;
	}
	}
	private void displayAlert() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertBuilder = 
				new AlertDialog.Builder(this);
		alertBuilder.setTitle("Dit is geen telefoon")
		.setMessage("Dit toestel kan niet bellen")
		.setPositiveButton("OK", new myDialogListener()).show();
	}
		
		class myDialogListener implements DialogInterface.OnClickListener{
			public void onClick(DialogInterface dialog, int whichButton){
				
		}
		
	}
	private boolean deviceIsAPhone() {
		// TODO Auto-generated method stub
		TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		return manager.getPhoneType()!= TelephonyManager.PHONE_TYPE_NONE;
	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mlocManager.removeUpdates(mlocListener);
		finish();
	}
	

	}