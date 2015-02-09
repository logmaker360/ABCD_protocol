package com.first.aid.abcd;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Menu extends ListActivity {
//afsluiten, contact.
	String classes[] = { "Naar begin / Afsluiten", "Herhaal ABCD", "Waar ben ik?" , 
			"Brandwonden", "Hyperventilatie", "Nek", "Reanimatie", 
			"Slagaderlijke bloeding" ,"Stabiele zijligging", "Verslikking", "Contact", "Disclamer"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes)); 
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		
		if(cheese.equals("Naar begin / Afsluiten")){
			cheese = "Naar_begin";
		}else if(cheese.equals("Herhaal ABCD")){
			cheese = "Herhaal_ABCD";
		}else if(cheese.equals("Slagaderlijke bloeding")){
			cheese = "Ader_of_Slagaderlijke_bloeding";
		}else if(cheese.equals("Waar ben ik?")){
			cheese = "Locatie";
		}else if(cheese.equals("Stabiele zijligging")){
			cheese = "Stabiele_zijligging";
		}
		
		
		try {
			Class ourClass = Class.forName("com.first.aid.abcd." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			ourIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
