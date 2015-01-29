package com.google.android.gms.maps.model;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSSafe;
import android.os.Parcel;

public class LatLngCreator {
	public static final int CONTENT_DESCRIPTION = 0; // just a guess 
    @DSSafe(DSCat.SAFE_OTHERS)
	public LatLngCreator() {}
	
    @DSSafe(DSCat.SAFE_OTHERS)
	public LatLng createFromParcel(Parcel parcel) {
		LatLng latlng = new LatLng(0, 0);
		latlng.latitude = parcel.readDouble();
		latlng.longitude = parcel.readDouble();
		return latlng;
	}
	
    @DSSafe(DSCat.SAFE_OTHERS)
	public LatLng[] newArray(int size) {
		return new LatLng[size];
	}
	
}
