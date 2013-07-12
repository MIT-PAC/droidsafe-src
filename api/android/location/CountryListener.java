package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface CountryListener {
    
    void onCountryDetected(Country country);
}
