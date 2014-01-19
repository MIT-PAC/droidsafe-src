package com.google.android.maps;
     
import droidsafe.annotations.*;

public class GeoPoint
{
    
    public GeoPoint() {
        
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public int getLatitudeE6()
    {
        return 0;
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public int getLongitudeE6() 
    { 
        return 0;
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public String toString() { 
        return "";
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public boolean equals(Object paramObject) { 
        return this == paramObject;
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public int hashCode() { 
        return 0;
    }
}
