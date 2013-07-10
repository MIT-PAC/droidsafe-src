package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

interface OnDependencyChangeListener {
    
    void onDependencyChanged(Preference dependency, boolean disablesDependent);
}
