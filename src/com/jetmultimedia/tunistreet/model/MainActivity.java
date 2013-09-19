package com.jetmultimedia.tunistreet.model;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;


import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;

import android.view.Menu;
import android.widget.TextView;

import com.example.notifierzonededanger.R;

public class MainActivity extends Activity {
	// GPS
	LocationManager vLocationManager;
	LocationListener vLocationListener;
	// Variables
	List<ZoneDanger> zones;
	List<ZoneDanger> vzone;
	String Cville = "tunis";
	ZoneDanger zoneDanger = new ZoneDanger();
	Location locationTmp = new Location("");
	Location zoneTest = new Location("");
	// Graphics
	TextView vTextView1;
	TextView vTextView2;
	TextView vTextView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		// GPS
//		vLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//		vLocationListener = new mylocationlistener();
//		vLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
//				0, 0, vLocationListener);
//		vTextView1 = (TextView) findViewById(R.id.textView1);
//		vTextView2 = (TextView) findViewById(R.id.textView2);
//		vTextView3 = (TextView) findViewById(R.id.textView3);
//		// Liste zones de danger
//		zones = new LinkedList<ZoneDanger>();
//		vzone = new LinkedList<ZoneDanger>();
//		Remplir(zones);
		Intent service = new Intent(this,OsmService.class);
		startService(service);

	}

//	private void Remplir(List<ZoneDanger> zones) {
//
//		zones.add(new ZoneDanger(0, 0, 36.831753, 10.275196, "tunis", "", "",
//				"", 0, ""));
//		zones.add(new ZoneDanger(0, 0, 36.832027, 10.236411, "tunis", "", "",
//				"", 0, ""));
//		zones.add(new ZoneDanger(0, 0, 36.443639, 10.71437, "Nabeul", "", "",
//				"", 0, ""));
//		zones.add(new ZoneDanger(0, 0, 35.774407, 10.83071, "Monastir", "", "",
//				"", 0, ""));
//	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
