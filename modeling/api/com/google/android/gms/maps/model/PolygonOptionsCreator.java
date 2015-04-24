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

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcel;
import java.util.ArrayList;
import droidsafe.annotations.*;

public class PolygonOptionsCreator implements android.os.Parcelable.Creator
{
    public static final int CONTENT_DESCRIPTION = 0;

    @DSSafe(DSCat.SAFE_LIST)
    public PolygonOptions createFromParcel(Parcel  r1)
    {
    	PolygonOptions o = new PolygonOptions();
    	o.addTaint(r1.getTaint());
    	return o;
    }

    public PolygonOptions[] newArray(int  i0)
    {
        return new PolygonOptions[i0];
    }

    static void a(PolygonOptions  r0, Parcel  r1, int  i0)
    {

       /* int i1;
        i1 = b.C(r1);
        b.c(r1, 1, r0.getVersionCode());
        b.b(r1, 2, r0.getPoints(), false);
        b.c(r1, 3, r0.jP(), false);
        b.a(r1, 4, r0.getStrokeWidth());
        b.c(r1, 5, r0.getStrokeColor());
        b.c(r1, 6, r0.getFillColor());
        b.a(r1, 7, r0.getZIndex());
        b.a(r1, 8, r0.isVisible());
        b.a(r1, 9, r0.isGeodesic());
        b.G(r1, i1);*/
    }
    
}
