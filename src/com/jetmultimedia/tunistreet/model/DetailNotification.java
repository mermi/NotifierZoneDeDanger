package com.jetmultimedia.tunistreet.model;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.notifierzonededanger.R;

public class DetailNotification extends Activity {
	//Graphics
	 TextView vcategorie;
	 TextView vlatitude;
	 TextView vlongitude;
	 TextView vadresse;
	 TextView vdescription;
	 TextView vevaluation;
	 Button close;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		//Déclaration des textView
		vcategorie = (TextView) findViewById(R.id.textView1);
		vlatitude = (TextView) findViewById(R.id.textView2);
		vlongitude = (TextView) findViewById(R.id.textView3);
		vadresse = (TextView) findViewById(R.id.textView4);
		vdescription = (TextView) findViewById(R.id.textView5);
		vevaluation = (TextView) findViewById(R.id.textView6);
		close = (Button) findViewById(R.id.button1);
		
		//importer les information avec getIntent par clé
		String type = this.getIntent().getStringExtra("categorie");
		String latitude = this.getIntent().getStringExtra("latitude");
		String longitude = this.getIntent().getStringExtra("longitude");
		String adresse = this.getIntent().getStringExtra("adresse");
		String description = this.getIntent().getStringExtra("description");
		String evaluation = this.getIntent().getStringExtra("evaluation");
		
		//afficher les informations 
		vcategorie.setText("Categorie:"+type);
		vlatitude.setText("Latitude:"+latitude);
		vlongitude.setText("Longitude:"+longitude);
		vadresse.setText("Adresse: "+adresse);
		vdescription.setText("Description: "+description);
		vevaluation.setText("Evaluation"+evaluation);
		final Intent finishIntent = new Intent(this, MainActivity.class);
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(finishIntent);
				
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
