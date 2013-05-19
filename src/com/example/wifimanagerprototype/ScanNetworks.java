package com.example.wifimanagerprototype;

import java.util.*;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class ScanNetworks {
	WifiManager wifi;
	WifiInfo info;
	
	public List<WifiConfiguration> scan(Context context) {
		// Setup WiFi
		wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		
		// Get WiFi status
		info = wifi.getConnectionInfo();
		
		// List available networks
		List<WifiConfiguration> configs = wifi.getConfiguredNetworks();
		
		return configs;
	}
}
