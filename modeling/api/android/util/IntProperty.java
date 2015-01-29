package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class IntProperty<T> extends Property<T, Integer> {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.319 -0500", hash_original_method = "9F5760D528759E010FD49A9F1F442123", hash_generated_method = "5170198E518218B35F11D3A944B5F964")
    
public IntProperty(String name) {
        super(Integer.class, name);
    }

    /**
     * A type-specific override of the {@link #set(Object, Integer)} that is faster when dealing
     * with fields of type <code>int</code>.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.321 -0500", hash_original_method = "5157CAFF347DB0A33B9E7A6A7812660D", hash_generated_method = "45B46B9487068829BB423C2B4DF73274")
    
public abstract void setValue(T object, int value);

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.323 -0500", hash_original_method = "5527FE1AD5362F0D3A9E99F21EF5A850", hash_generated_method = "7662A3AD37A7C3FE9293D619A5E0228B")
    
@Override
    final public void set(T object, Integer value) {
        set(object, value.intValue());
    }
    
}

