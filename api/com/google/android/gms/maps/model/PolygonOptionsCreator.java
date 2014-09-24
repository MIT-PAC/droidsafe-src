package com.google.android.gms.maps.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcel;
import java.util.ArrayList;

public class PolygonOptionsCreator implements android.os.Parcelable.Creator
{
    public static final int CONTENT_DESCRIPTION = 0;

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
