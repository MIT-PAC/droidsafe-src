package com.google.android.maps;
     
import droidsafe.annotations.*;     

public class GeoPoint
{
    @DSModeled(DSC.SAFE)
    public int getLatitudeE6()
    {
        return 0;
    } 

    @DSModeled(DSC.SAFE)
    public int getLongitudeE6() 
    { 
        return 0;
    }
    
    @DSModeled(DSC.SAFE)
    public String toString() { 
        return "";
    } 

    @DSModeled(DSC.SAFE)
    public boolean equals(Object paramObject) { 
        return this == paramObject;
    } 

    @DSModeled(DSC.SAFE)
    public int hashCode() { 
        return 0;
    }
}
