package com.google.android.gms.maps.model;

import android.os.Parcel;

public class LatLngCreator {
	public static final int CONTENT_DESCRIPTION = 0; // just a guess 
	public LatLngCreator() {}
	
	public LatLng createFromParcel(Parcel parcel) {
		LatLng latlng = new LatLng(0, 0);
		latlng.latitude = parcel.readDouble();
		latlng.longitude = parcel.readDouble();
		return latlng;
	}
	
	public LatLng[] newArray(int size) {
		return new LatLng[size];
	}
	
}
