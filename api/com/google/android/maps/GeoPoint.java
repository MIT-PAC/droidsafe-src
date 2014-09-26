package com.google.android.maps;
     
import droidsafe.annotations.*;

public class GeoPoint
{
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public GeoPoint() {
        
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSSafe(DSCat.LOCATION)
    public int getLatitudeE6()
    {
        return 0;
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSSafe(DSCat.LOCATION)
    public int getLongitudeE6() 
    { 
        return 0;
    }
    
    @DSSafe(DSCat.LOCATION)
    public String toString() {
        
        return "";
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSSafe(DSCat.LOCATION)
    public boolean equals(Object paramObject) { 
        return this == paramObject;
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSSafe(DSCat.LOCATION)
    public int hashCode() { 
        return 0;
    }
}
