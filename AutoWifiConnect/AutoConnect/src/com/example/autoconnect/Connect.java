package com.example.autoconnect;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class Connect extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
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
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.connect, menu);
        return true;
    }
    
}
