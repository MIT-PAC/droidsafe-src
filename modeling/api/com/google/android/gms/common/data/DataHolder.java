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
