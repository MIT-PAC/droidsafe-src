package android.preference;

// Droidsafe Imports

interface OnDependencyChangeListener {
    
    void onDependencyChanged(Preference dependency, boolean disablesDependent);
}
