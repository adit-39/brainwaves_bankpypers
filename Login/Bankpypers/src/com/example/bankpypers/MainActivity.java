package com.example.bankpypers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
	        WifiConfiguration wc = new WifiConfiguration();
	        wc.SSID = "\"free virus\"";
	        wc.preSharedKey  = "\"svarun115\"";
	        wc.hiddenSSID = true;
	        wc.status = WifiConfiguration.Status.ENABLED;        
	        wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
	        wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
	        wc.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
	        wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
	        wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
	        wc.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
	        int res = wifi.addNetwork(wc);
	        Log.d("WifiPreference", "add Network returned " + res );
	        boolean b = wifi.enableNetwork(res, true);        
	        Log.d("WifiPreference", "enableNetwork returned " + b );
			Thread logoTimer = new Thread() {
	            public void run(){
	                try{
	                    int logoTimer = 0;
	                    while(logoTimer < 3000){
	                        sleep(100);
	                        logoTimer = logoTimer +100;
	                    };
	                    
	                    startActivity(new Intent("com.example.bankpypers.SIGNIN"));
	                } 
	                 
	                catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                 
	                finally{
	                    finish();
	                }
	            }
	        };
	         
	        logoTimer.start();
	}
	
//	private class splash extends AsyncTask<String, Void, String>
//	{
//		String mac;
//
//		@Override
//		protected String doInBackground(String... params) {
//				mac=Utils.getMACAddress("wlan0");
//				HttpClient httpclient = new DefaultHttpClient();
//				HttpGet httpget = new HttpGet("http://192.168.222.113:5000/api/get_balance/0422101050919");
//				try {
//					HttpResponse response = httpclient.execute(httpget);
//					//android.util.Log.d("response", );
//					String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//					System.out.println(responseString);
//				} catch (ClientProtocolException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return null;
//		}
//		
//		protected void onPostExecute(String result){
//
//			Toast.makeText(getApplicationContext(), mac, Toast.LENGTH_LONG).show();
//
//		}
//		
//	}
		
}


