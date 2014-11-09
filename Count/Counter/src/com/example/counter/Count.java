package com.example.counter;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

public class Count extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count);
		final TextView mTextField = (TextView) findViewById(R.id.textView1);
		new CountDownTimer(3000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 int hours = (int)millisUntilFinished/3600000;
		    	 int minutes = (int)millisUntilFinished/60000 - hours * 60;
		    	 int seconds = (int)millisUntilFinished/1000 - minutes * 60 - hours * 3600;
		         mTextField.setText("Time remaining: " + ((hours>9)?hours:("0"+hours)) + ":" + ((minutes>9)?minutes:("0"+minutes)) + ":" + seconds);
		     }

		     public void onFinish() {
		         mTextField.setText("done!");
		         Toast.makeText(getApplicationContext(), "crazzzzzzy`", Toast.LENGTH_LONG).show();
		         NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext());
		         mBuilder.setSmallIcon(R.drawable.ic_launcher);
		         mBuilder.setContentTitle("Notification Alert, Click Me!");
		         mBuilder.setContentText("Hi, This is Android Notification Detail!");
		         
//		         Intent resultIntent = new Intent(this, ResultActivity.class);
//		         TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//		         stackBuilder.addParentStack(ResultActivity.class);
//
//		         // Adds the Intent that starts the Activity to the top of the stack
//		         stackBuilder.addNextIntent(resultIntent);
//		         PendingIntent resultPendingIntent =
//		                 stackBuilder.getPendingIntent(
//		                     0,
//		                     PendingIntent.FLAG_UPDATE_CURRENT
//		                 );
//		         mBuilder.setContentIntent(resultPendingIntent);
		         
		         NotificationManager mNotificationManager =
		        		    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		         mNotificationManager.notify(100, mBuilder.build());
		     }
		  }.start();
	}

}
