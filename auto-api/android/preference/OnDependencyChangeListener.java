package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

interface OnDependencyChangeListener {
    
    void onDependencyChanged(Preference dependency, boolean disablesDependent);
}
