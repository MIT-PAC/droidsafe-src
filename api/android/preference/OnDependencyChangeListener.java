package android.preference;

// Droidsafe Imports
import droidsafe.annotations.*;

interface OnDependencyChangeListener {
    
    void onDependencyChanged(Preference dependency, boolean disablesDependent);
}
