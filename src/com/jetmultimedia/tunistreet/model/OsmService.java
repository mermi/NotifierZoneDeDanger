package com.jetmultimedia.tunistreet.model;

import java.util.LinkedList;
import java.util.List;

import com.example.notifierzonededanger.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import android.widget.Toast;


public class OsmService extends Service {
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
		

	  @Override
	  public void onCreate() {
	    
		  vLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			vLocationListener = new mylocationlistener();
			vLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
					0, 0, vLocationListener);
			
			
			// Liste zones de danger
			zones = new LinkedList<ZoneDanger>();
			vzone = new LinkedList<ZoneDanger>();
			Remplir(zones);
			//createNotification();
	  }
	  
		private void Remplir(List<ZoneDanger> zones) {

			zones.add(new ZoneDanger(0, 0, 36.831753, 10.275196, "tunis", "", "",
					"", 0, ""));
			zones.add(new ZoneDanger(0, 0, 36.832027, 10.236411, "tunis", "", "",
					"", 0, ""));
			zones.add(new ZoneDanger(0, 0, 36.443639, 10.71437, "Nabeul", "", "",
					"", 0, ""));
			zones.add(new ZoneDanger(0, 0, 35.774407, 10.83071, "Monastir", "", "",
					"", 0, ""));
		}
		
	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	      Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

	    
	      // If we get killed, after returning from here, restart
	      return START_STICKY;
	  }

	  @Override
	  public IBinder onBind(Intent intent) {
	      // We don't provide binding, so return null
	      return null;
	  }
	  
	  @Override
	  public void onDestroy() {
	    Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show(); 
	  }
	  
	private class mylocationlistener implements LocationListener {
			// Ecouteur sur le GPS, appelé à chaque changement de position

			public void onLocationChanged(Location location) {

				// si une position est renvoyé par le GPS
				if (location != null) {
					// selectionner les zones de dangers de la même ville
					for (ZoneDanger zone : zones) {
						if (zone.getAdresse().equals(Cville)) {

							vzone.add(zone);
						}
					}
					// première zone de la liste
					zoneDanger = vzone.get(0);
					// récupérer latitude et longitude du première élément
					locationTmp.setLatitude(zoneDanger.getLatitude());
					locationTmp.setLongitude(zoneDanger.getLongitude());
					// calculer la distance minimale
					double distanceMin = location.distanceTo(locationTmp);
					// parcourir la liste
					for (ZoneDanger zone : vzone) {
						// récupérer latitude et longitude
						locationTmp.setLatitude(zone.getLatitude());
						locationTmp.setLongitude(zone.getLongitude());
						// calculer la distance
						// comparer avec la distance minimale initial
						double distance = location.distanceTo(locationTmp);
						if (distance < distanceMin) {
							distanceMin = distance;
							
						}
					}

					// afficher la distance distance
					
					// si l'utilisateur est proche de la zone de danger
					if (distanceMin < 500) {
						// afficher un msg pour indiquer qu'il est prêt de la zone
						// créer une notification qui nous indique le type de danger
						createNotification();
					}
				}
			}

			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
			}

			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
			}

			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
			}
		} // fin class interne

		static private final int NOTIFICATION_ID = 1;

		private void createNotification() {
			NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
					this).setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle("Radar")
					.setContentText("Attention il y a un radar à 100m ");
			// Creates an explicit intent for an Activity in your app
			Intent resultIntent = new Intent(this, DetailNotification.class);
			resultIntent.putExtra("categorie", "Radar");
			resultIntent.putExtra("latitude", "36.831959");
			resultIntent.putExtra("longitude", "10.236497");
			resultIntent.putExtra("adresse", "Rue du Lac Turkana");
			resultIntent.putExtra("description", "Radar fixe");
			resultIntent.putExtra("evaluation", "+10");
			// The stack builder object will contain an artificial back stack for
			// thel
			// started Activity.
			// This ensures that navigating backward from the Activity leads out of
			// your application to the Home screen.
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
			// Adds the back stack for the Intent (but not the Intent itself)
			stackBuilder.addParentStack(MainActivity.class);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
					PendingIntent.FLAG_UPDATE_CURRENT);
			mBuilder.setContentIntent(resultPendingIntent);
			NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			// mId allows you to update the notification later on.
			mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
		}

}
