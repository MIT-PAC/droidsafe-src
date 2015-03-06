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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;

public class CameraPositionCreator implements android.os.Parcelable.Creator
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:18:07.659 -0400", hash_original_field = "BE7571FEE68510C5B2ABCBF2C7161CA5", hash_generated_field = "A4CA75FA70F636AD154C8D958F52817C")

    public static final int CONTENT_DESCRIPTION = 0;

	CameraPositionCreator(DSOnlyType dontcare) {
		
	}

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:18:07.727 -0400", hash_original_method = "30366B87AFEC637BAA5E05D3B236D25E", hash_generated_method = "BC5EA8986C0360590F8351CDBD17229D")
    
    public Object createFromParcel(Parcel  r1)
    {
    	float f = r1.readFloat();
    	LatLng position = new LatLng(f,  f);
    	
    	CameraPosition pos = new CameraPosition(position, f, f, f);
    	return pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:18:07.719 -0400", hash_original_method = "CA11DFF75F0E87181B5E1251583553C5", hash_generated_method = "A10880B56629EEA2D9F33229531F720D")
    
    public Object[] newArray(int  i0)
    {
    	return new CameraPosition[i0];
    }

}
