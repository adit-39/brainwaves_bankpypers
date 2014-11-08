package com.example.bankpypers;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		splash obj = new splash();
		obj.execute();
	}
	
	private class splash extends AsyncTask<String, Void, String>
	{
		String mac;

		@Override
		protected String doInBackground(String... params) {
				mac=Utils.getMACAddress("wlan0");
				HttpClient httpclient = new DefaultHttpClient();
				HttpGet httpget = new HttpGet("http://192.168.43.187:5000/api/get_balance/0422101050919");
				try {
					HttpResponse response = httpclient.execute(httpget);
					android.util.Log.d("response", response.toString());
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		}
		
		protected void onPostExecute(String result){

			Toast.makeText(getApplicationContext(), mac, Toast.LENGTH_LONG).show();

		}
		
	}
		
}


