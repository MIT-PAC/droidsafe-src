package com.google.android.gms.common.data;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSSpec;
import droidsafe.annotations.DSVerified;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class DataHolder implements Parcelable {
	
	public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
		
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return getTaintInt();
	}

	@Override
	@DSVerified
	@DSSpec(DSCat.ABSTRACT_METHOD)
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(flags + getTaintInt());
		
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return getTaintInt();
	}

	public boolean isClosed() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

}
