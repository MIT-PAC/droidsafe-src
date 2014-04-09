package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Map;
import java.util.Set;

public interface SharedPreferences {
    
    public interface OnSharedPreferenceChangeListener {
        
        void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key);
    }
    
    public interface Editor {
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putString(String key, String value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putStringSet(String key, Set<String> values);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putInt(String key, int value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putLong(String key, long value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putFloat(String key, float value);
        
        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor putBoolean(String key, boolean value);

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor remove(String key);

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        Editor clear();

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean commit();

        @DSVerified("no callback, delegated to implementation")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void apply();
    }

    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.SAFE_OTHERS)
    Map<String, ?> getAll();

    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    String getString(String key, String defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    Set<String> getStringSet(String key, Set<String> defValues);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    int getInt(String key, int defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    long getLong(String key, long defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    float getFloat(String key, float defValue);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    boolean getBoolean(String key, boolean defValue);

    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean contains(String key);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Editor edit();

    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener);
    
    @DSVerified("no callback, delegated to implementation")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener);
}
