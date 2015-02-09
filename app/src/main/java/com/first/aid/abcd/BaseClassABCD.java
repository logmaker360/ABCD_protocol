package com.first.aid.abcd;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BaseClassABCD extends Activity{
	
	//menu
		private void displayAlert() {
			// TODO Auto-generated method stub
			AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
			alertBuilder.setTitle("Dit is geen telefoon")
					.setMessage("Dit toestel kan niet bellen")
					.setPositiveButton("OK", new myDialogListener()).show();
		}

		class myDialogListener implements DialogInterface.OnClickListener {
			public void onClick(DialogInterface dialog, int whichButton) {

			}

		}

		private boolean deviceIsAPhone() {
			// TODO Auto-generated method stub
			TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
			return manager.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// TODO Auto-generated method stub
			super.onCreateOptionsMenu(menu);
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.list_menu, menu);
			return true;
		}
		
				
			
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			
			switch(item.getItemId()){
			
			case R.id.menu_BelAlarmnummer:
				//bel 112
				boolean isOk = true;
				Intent intent = new Intent();
				
				if(!deviceIsAPhone()){
					displayAlert();
					isOk = false;	
				}
				if (isOk){
					intent.setAction(Intent.ACTION_DIAL);
					intent.setData(Uri.parse("tel:112"));
					startActivity(intent);
				}

				break;
				
			case R.id.menu_naarMenu:
				//naar Activity startMenu
					Class ourClass1;
					try {
						ourClass1 = Class.forName("com.first.aid.abcd.Menu");
						Intent intentDrie = new Intent(BaseClassABCD.this, ourClass1);
						intentDrie.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
						startActivity(intentDrie);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				break;
			case R.id.menu_sluitAf:
				Class ourClass3;
				try {
					ourClass3 = Class.forName("com.first.aid.abcd.Eerste");
					Intent intentDrie = new Intent(BaseClassABCD.this, ourClass3);
					intentDrie.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentDrie);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finish();
				break;
				
			case R.id.menu_WaarBenIk:
				//naar activity Locatie
					Class ourClass4;
					try {
						ourClass4 = Class.forName("com.first.aid.abcd.Locatie");
						Intent intentVier = new Intent(BaseClassABCD.this, ourClass4);
						intentVier.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
						startActivity(intentVier);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				
				break;
			
			}
			
			return super.onOptionsItemSelected(item);
		}

}
