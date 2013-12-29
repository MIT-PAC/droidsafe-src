package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;

public interface LocationListener {

    @DSModeled(DSC.SAFE)
    void onLocationChanged(Location location);

    @DSModeled(DSC.SAFE)
    void onStatusChanged(String provider, int status, Bundle extras);

    @DSModeled(DSC.SAFE)
    void onProviderEnabled(String provider);

    @DSModeled(DSC.SAFE)
    void onProviderDisabled(String provider);
}
