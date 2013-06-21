package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;

public interface LocationListener {

    
    void onLocationChanged(Location location);

    
    void onStatusChanged(String provider, int status, Bundle extras);

    
    void onProviderEnabled(String provider);

    
    void onProviderDisabled(String provider);
}
