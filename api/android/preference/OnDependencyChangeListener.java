package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

interface OnDependencyChangeListener {
    
    void onDependencyChanged(Preference dependency, boolean disablesDependent);
}
