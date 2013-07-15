package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;

public interface LocationListener {

    
    void onLocationChanged(Location location);

    
    void onStatusChanged(String provider, int status, Bundle extras);

    
    void onProviderEnabled(String provider);

    
    void onProviderDisabled(String provider);
}
