/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
