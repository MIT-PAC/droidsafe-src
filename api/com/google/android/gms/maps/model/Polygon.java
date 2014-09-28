package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.RemoteException;
import java.util.List;

public final class Polygon
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.997 -0400", hash_original_method = "5D356F830FE29E232E7449ECF04D158D", hash_generated_method = "058782B03BA5576C9A6E14CCC4D90F7B")
    
    public Polygon(DSOnlyType dontcare)
    {

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.000 -0400", hash_original_method = "8C5C8D440A9E2FD14E570298FDD80D93", hash_generated_method = "6DFFC6DF15A18B80DE947DB1F4A773FF")
    
public void remove()
    {
    }

    String id;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.004 -0400", hash_original_method = "FF8F73CDACA1926464C090DBDC1E5E35", hash_generated_method = "0F91495B456F24F5D2FF5C8FEA4FF616")
    
public String getId()
    {
    	if (id == null) {
            id = new String();
            id.addTaint(hashCode());
    	}
    	return id;
    }

    List points;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.007 -0400", hash_original_method = "43A7FCF1D5B33B9C8A1FD7D5A74D5766", hash_generated_method = "11169936EEEDBFA8BF64CE34B349455E")
    
public void setPoints(List  r1)
    {
    	points = r1;
    }

    @DSSource({DSSourceKind.LOCATION})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.010 -0400", hash_original_method = "1CE7B9C76662FF9B11920E114F5ED131", hash_generated_method = "50CF9278E96BAF04ECA29F85C99639AA")
    
public List getPoints()
    {
    	return points;
    }

    List holes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.013 -0400", hash_original_method = "540EA65786A6CEF54BA67A4F73AD0AA2", hash_generated_method = "1D8717EB6BA8E31FE3BED5F985F557A0")
    
public void setHoles(List  r1)
    {
    	holes = r1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.016 -0400", hash_original_method = "72C76F6A0138DBADD2243BA67FF59444", hash_generated_method = "465A32F039545738C2F1962FD03E84FC")
    
public List getHoles()
    {
    	return holes;
    }
    
    float stroke;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.020 -0400", hash_original_method = "DA976986F802679963E9F62E1D6B541D", hash_generated_method = "976E773AE63F558C93485FB9050FA001")
    
public void setStrokeWidth(float  f0)
    {
    	stroke = f0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.023 -0400", hash_original_method = "09FBD8ABAF55D9CFEDB61CB913012262", hash_generated_method = "3168A60EFB6A4637682F3FBDE9A15526")
    
public float getStrokeWidth()
    {
    	return stroke;
    }

    int strokeColor;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.027 -0400", hash_original_method = "BBD989D6CBC21458D9DEB85045B23A82", hash_generated_method = "D84E946B9FCD6C8B19A517C41C0C0892")
    
public void setStrokeColor(int  i0)
    {
    	strokeColor = i0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.030 -0400", hash_original_method = "B761B432F77F4E3E6288B55663E64E3C", hash_generated_method = "A2660EA3178F85CC7591A68429FB826B")
    
public int getStrokeColor()
    {
    	return strokeColor;
    }

    int fillColor;
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.034 -0400", hash_original_method = "B7529198E3F1F8C6F039CD825BEB2732", hash_generated_method = "211ADD048FB0A8A556B53A3F6F23A977")
    
public void setFillColor(int  i0)
    {
    	fillColor = i0;
      
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.037 -0400", hash_original_method = "770F7277A0B3A9B92859B0055B7810C5", hash_generated_method = "7F73A441E2F9F5BCAE6E9185695454B0")
    
public int getFillColor()
    {
    	return fillColor;
    }

    float zIndex;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.040 -0400", hash_original_method = "1C41F0EF4CE47500168662725751FC2E", hash_generated_method = "71342D8A874A58777BB520BEACED0088")
    
public void setZIndex(float  f0)
    {
    	zIndex = f0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.043 -0400", hash_original_method = "85018FAB6389E625B781E4754A542D50", hash_generated_method = "27863BF5301AD07570DA618423046919")
    
public float getZIndex()
    {
    	return zIndex;
    }

    boolean visible;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.046 -0400", hash_original_method = "4F1D59F1FE23C1AC9513AD19CD3A381A", hash_generated_method = "1D75F6E28B0DA69907E5BD97376FDDD7")
    
public void setVisible(boolean  z0)
    {
    	visible = z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.050 -0400", hash_original_method = "D0D9A515AA133B22E112ED8C217D651B", hash_generated_method = "D7FAF0C5FF9EEE2BF8DAC0948A0A33BA")
    
public boolean isVisible()
    {
    	return visible;
    }

    boolean geodesic;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.053 -0400", hash_original_method = "9E3F79BF02D936DA6DA927D155342848", hash_generated_method = "621C8FB7EBCF5C1825AEFCCE761831E2")
    
public void setGeodesic(boolean  z0)
    {
    	geodesic = z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.057 -0400", hash_original_method = "D296E362984742F16797650354EB2877", hash_generated_method = "AC6DD5249017B1481DBE6AAFA4A796B3")
    
public boolean isGeodesic()
    {
    	return geodesic;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.060 -0400", hash_original_method = "809AF0F364938F8F716C89E088C8C53E", hash_generated_method = "377BDCC703B3DE85CF40BFBB6E1F71BE")
    
public boolean equals(Object  r1)
    {
    	return DSUtils.toTaintBoolean(hashCode() + r1.hashCode());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.063 -0400", hash_original_method = "9550DE143575228768275CC736E1A5FF", hash_generated_method = "A1B92EE775D4E6ACE2E8E8B69017F7F7")
    
public int hashCode()
    {
    	return (int)(
    			fillColor + stroke + strokeColor + zIndex +
    			DSUtils.toTaintFloat(geodesic && visible) +
    			id.hashCode() + points.get(0).hashCode() +
    			holes.get(0).hashCode());
      
    }
}
